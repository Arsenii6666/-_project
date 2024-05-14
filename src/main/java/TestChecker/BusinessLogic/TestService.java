package TestChecker.BusinessLogic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.stereotype.Service;

import AssessmentJournal.Data.Grade;
import TestChecker.Data.Question;
import TestChecker.Data.Test;

import java.util.ArrayList;
import java.util.Optional;


@Service
@EnableAsync
public class TestService {

    @Autowired
    private TestRepository testRepository;

    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    private final String QUEUE_NAME = "testsQueue";

    public final static String MAP_NAME = "testsMap";

    private final RestTemplate restTemplate = new RestTemplate();;

    private final String ASSESSMENT_JOURNAL_BASE_URL = "http://localhost:8081/grades/";

    public Test createTest(List<List<String>> test, Long originId) {
        List<Question> aQuestion = new ArrayList<>();
        for (List<String> l : test) {
            aQuestion.add(new Question(l.get(0), Boolean.parseBoolean(l.get(1)), null));
        }
        Test toSave = new Test(aQuestion);
        for (Question q : toSave.getQuestions()) {
            q.setTest(toSave);
        }
        toSave.setOriginId(originId);
        return testRepository.save(toSave);
    }

    public Test getTestById(Long id) {
        Optional<Test> testOptional = testRepository.findById(id);
        return testOptional.orElse(null);
    }

    public Grade getGradeByTestId(Long id) {
        IMap<Long, Grade> testResultsMap = hazelcastInstance.getMap(TestService.MAP_NAME);
        while (testResultsMap.get(id) == null) {continue;}
        return testResultsMap.get(id);
    }

    public Test submitTest(Long originId, List<List<String>> testContent) {
        Test testToEvaluate = createTest(testContent, originId);
        IQueue<Test> testQueue = hazelcastInstance.getQueue(QUEUE_NAME);
        testQueue.offer(testToEvaluate);
        return testToEvaluate;
    }

    @Async
    @Scheduled(fixedDelay = 1000)
    private Grade evaluateTest() throws InterruptedException {
        System.out.println("EVALUATE TEST");;
        IMap<Long, Grade> testResultsMap = hazelcastInstance.getMap(TestService.MAP_NAME);
        IQueue<Test> testQueue = hazelcastInstance.getQueue(QUEUE_NAME);
        Test test = testQueue.poll();
        Optional<Test> originTest = testRepository.findById(test.getOriginId());
        if (!originTest.isPresent()) {
            System.err.println("ERROR: ORIGIN TEST WITH THIS ID DOES NOT EXIST: " + test.getOriginId());
            return null;
        }
        Grade grade = originTest.get().evaluate(test);
        restTemplate.postForObject(ASSESSMENT_JOURNAL_BASE_URL + "/submit-grade",
                grade, String.class);
        testResultsMap.put(test.getId(), grade);
        return grade;
    }
}
