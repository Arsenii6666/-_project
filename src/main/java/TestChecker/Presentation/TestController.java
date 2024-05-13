package TestChecker.Presentation;

import TestChecker.BusinessLogic.TestService;
import TestChecker.Data.Question;
import TestChecker.Data.Test;
import AssessmentJournal.Data.Grade;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

@RestController
@RequestMapping("/tests/")
public class TestController {

    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    @Autowired
    private TestService testService;

    @PostMapping("/create")
    public Test createTest(@RequestBody List<List<String>> test) {
        return testService.createTest(test, -1l);
    }

    @GetMapping("/{id}")
    public Test getTestById(@PathVariable Long id) {
        return testService.getTestById(id);
    }

    @PostMapping("/submit/{origin_id}")
    public Grade submitTest(@PathVariable("origin_id") Long originId, @RequestBody List<List<String>> toSubmit) {
        Test submittedTest = testService.submitTest(originId, toSubmit);
        IMap<Long, Grade> testResultsMap = hazelcastInstance.getMap(TestService.MAP_NAME);
        Long idToGet = submittedTest.getId();
        return testService.getGradeByTestId(submittedTest.getId());
    }
}
