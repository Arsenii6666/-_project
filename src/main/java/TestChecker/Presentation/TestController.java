package TestChecker.Presentation;

import TestChecker.BusinessLogic.TestService;
import TestChecker.Data.Question;
import TestChecker.Data.Test;
import AssessmentJournal.Data.Grade;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tests/")
public class TestController {

    @Autowired
    private TestService testService;

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

