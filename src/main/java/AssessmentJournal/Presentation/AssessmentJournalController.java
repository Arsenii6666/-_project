package AssessmentJournal.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import AssessmentJournal.BusinessLogic.AssessmentJournalService;
import AssessmentJournal.Data.Grade;
import TestChecker.Data.Test;

import java.util.List;

@RestController
@RequestMapping("/")
public class AssessmentJournalController {
    @Autowired
    private final AssessmentJournalService assessmentJournalService;

    public AssessmentJournalController(AssessmentJournalService assessmentJournalService) {
        this.assessmentJournalService = assessmentJournalService;
    }

    @PostMapping("/courses/{course_id}/students/{client_id}/submit-grade")
    public String submitGrade(@PathVariable("course_id") Long courseId,
                              @PathVariable("client_id") Long clientId,
                              @RequestBody Test test) {
        return assessmentJournalService.submitTestResults(courseId, clientId, test);
    }

    @GetMapping("/courses/{course_id}/students/{client_id}/grades")
    public List<Grade> getStudentGradesInCourse(@PathVariable("course_id") Long courseId,
                                               @PathVariable("client_id") Long clientId) {
        return assessmentJournalService.getStudentGradesInCourse(courseId, clientId);
    }
}
