package AssessmentJournal.Presentation;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import AssessmentJournal.BusinessLogic.AssessmentJournalService;
import TestChecker.BusinessLogic.Test;

@RestController
@RequestMapping("/")
public class AssessmentJournalController {
    private AssessmentJournalService assessmentJournalService;

    public AssessmentJournalController() {}

    @Autowired
    public AssessmentJournalController(AssessmentJournalService aAssessmentJournalService) {
        this.assessmentJournalService = aAssessmentJournalService;
    }

    @PostMapping("/tests/{test_id}/submit")
    public String submitTestResults(@PathVariable("test_id") Long testId, @RequestBody Test test) {
        return assessmentJournalService.submitTestResults(testId, test);
    }

    // @GetMapping("/tests/{test_id}/grades")
    // public TestGradesDTO getTestGrades(@PathVariable("test_id") Long testId) {
    //     return assessmentJournalService.getTestGrades(testId);
    // }

    // @GetMapping("/students/{student_id}/grades")
    // public StudentGradesDTO getStudentGrades(@PathVariable("student_id") Long studentId) {
    //     return assessmentJournalService.getStudentGrades(studentId);
    // }
}
