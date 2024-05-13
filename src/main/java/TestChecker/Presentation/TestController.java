package TestChecker.Presentation;

import TestChecker.BusinessLogic.TestChecker;
import TestChecker.BusinessLogic.TestService;
import TestChecker.Data.Question;
import TestChecker.Data.Test;
import AssessmentJournal.Data.Grade;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/tests/")
public class TestController {

    @Autowired
    private TestService testService;

    private static final Map<String, String> testMap = new HashMap<>();

    @Autowired
    public TestController(RestTemplate restTemplate) {
        HazelcastInstance hz = TestCheckerApplication.hz;
        TestChecker testChecker = new TestChecker();
        IQueue<String> messageQueue = hz.getQueue("message-queue");
        new Thread(() -> {
            while (true) {
                try {
                    String payloadString = messageQueue.take();
                    System.out.println(testChecker.submit(payloadString));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @PostMapping("/create")
    public Test createTest(@RequestBody List<List<String>> test) {
        return testService.createTest(test);
    }

    @GetMapping("/{id}")
    public Test getTestById(@PathVariable Long id) {
        return testService.getTestById(id);
    }

    @PostMapping("/{id}/submit")
    public Grade submitTest(@PathVariable Long id, @RequestBody Test testSubmissionDTO) {
        System.err.println("IMPLEMENT TEST SUBMISSION YOU DUMBASS");
        return null;
    }
}

