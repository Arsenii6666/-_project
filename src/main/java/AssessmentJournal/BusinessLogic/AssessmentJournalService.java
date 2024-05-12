package AssessmentJournal.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AssessmentJournal.BusinessLogic.AssessmentJournalRepository;
import TestChecker.BusinessLogic.Test;

@Service
public class AssessmentJournalService {
    
    private AssessmentJournalRepository assessmentJournalRepository;

    public AssessmentJournalService() {}

    @Autowired(required = true)
    public AssessmentJournalService(AssessmentJournalRepository aAssessmentJournalRepository) {
        this.assessmentJournalRepository = aAssessmentJournalRepository;
    }

    public String submitTestResults(Long testId, Test test) {
        return "";
    }

}
