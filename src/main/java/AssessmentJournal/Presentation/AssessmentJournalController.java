package AssessmentJournal.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import AssessmentJournal.BusinessLogic.AssessmentJournalService;
import AssessmentJournal.Data.Grade;
import TestChecker.Data.Test;

import java.util.List;

@RestController
@RequestMapping("/grades/")
@ComponentScan(basePackages = {"AssessmentJournal.BusinessLogic", "AssessmentJournal.Presentation", "AssessmentJournal.Data"})
public class AssessmentJournalController {
    @Autowired
    private final AssessmentJournalService assessmentJournalService;

    public AssessmentJournalController(AssessmentJournalService assessmentJournalService) {
        this.assessmentJournalService = assessmentJournalService;
    }

    @PostMapping("/submit-grade")
    public String submitGrade(@RequestBody Grade grade) {
        return assessmentJournalService.submitTestResults(grade);
    }

    @GetMapping("/{grade_id}")
    public Grade getGrade(@PathVariable("grade_id") String gradeId) {
        return assessmentJournalService.getGrade(gradeId);
    }
}
