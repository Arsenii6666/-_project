package TestChecker.BusinessLogic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AssessmentJournal.Data.Grade;
import TestChecker.Data.Question;
import TestChecker.Data.Test;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public Test createTest(List<List<String>> test) {
        List<Question> aQuestion = new ArrayList<>();
        for (List<String> l : test) {
            aQuestion.add(new Question(l.get(0), Boolean.parseBoolean(l.get(1)), null));
        }
        Test toSave = new Test(aQuestion);
        for (Question q : toSave.getQuestions()) {
            q.setTest(toSave);
        }
        return testRepository.save(toSave);
    }

    public Test getTestById(Long id) {
        Optional<Test> testOptional = testRepository.findById(id);
        return testOptional.orElse(null);
    }

    public Test updateTest(Long id, Test test) {
        test.setId(id);
        return testRepository.save(test);
    }

    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }

    public Grade submitTest(Long id, Test testSubmissionDTO) {
        return null;
    }
}
