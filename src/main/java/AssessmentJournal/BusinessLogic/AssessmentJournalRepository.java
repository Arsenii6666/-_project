package AssessmentJournal.BusinessLogic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import AssessmentJournal.Data.Grade;

@Repository
public interface AssessmentJournalRepository extends JpaRepository<Grade, Long> {

    List<Grade> findGradesByTestId(Long testId);

    List<Grade> findGradesByClientProfileId(Long studentId);

    List<Grade> findGradesByClientProfileIdAndCourseId(Long studentId, Long courseId);
}
