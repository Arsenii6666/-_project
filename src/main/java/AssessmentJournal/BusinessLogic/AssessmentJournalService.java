package AssessmentJournal.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AssessmentJournal.BusinessLogic.AssessmentJournalRepository;
import AssessmentJournal.Data.Grade;
import TestChecker.Data.Test;

import java.util.List;

@Service
public class AssessmentJournalService {
    @Autowired
    private final AssessmentJournalRepository assessmentJournalRepository;

    public AssessmentJournalService(AssessmentJournalRepository assessmentJournalRepository) {
        this.assessmentJournalRepository = assessmentJournalRepository;
    }

    public String submitTestResults(Long courseId, Long clientId, Test test) {
        // assessmentJournalRepository.save(test);
        System.err.println("HEEEEEEEEEY IMPLEMENT TEST RESULTS CALCULATIONS YOU DUMBASS");
        return "Test results submitted unsuccessfully.";
    }

    public List<Grade> getTestGrades(Long testId) {
        return assessmentJournalRepository.findGradesByTestId(testId);
    }

    public List<Grade> getStudentGrades(Long studentId) {
        return assessmentJournalRepository.findGradesByClientProfileId(studentId);
    }

    public List<Grade> getStudentGradesInCourse(Long courseId, Long studentId) {
        return assessmentJournalRepository.findGradesByClientProfileIdAndCourseId(studentId, courseId);
    }
}
