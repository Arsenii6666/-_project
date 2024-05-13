package AssessmentJournal.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import AssessmentJournal.Data.Grade;
import TestChecker.Data.Test;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentJournalService {

    @Autowired
    private final AssessmentJournalRepository assessmentJournalRepository;

    public AssessmentJournalService(AssessmentJournalRepository assessmentJournalRepository) {
        this.assessmentJournalRepository = assessmentJournalRepository;
    }

    public String submitTestResults(Grade grade) {
        assessmentJournalRepository.save(grade);
        return "Test results submitted successfully.";
    }

    public Grade getGrade(String gradeId) {
        Optional<Grade> grade = assessmentJournalRepository.findById(gradeId);
        if (!grade.isPresent()) {
            System.err.println("NO GRADE WITH ID " + gradeId);
            return null;
        }
        return grade.get();
    }
}
