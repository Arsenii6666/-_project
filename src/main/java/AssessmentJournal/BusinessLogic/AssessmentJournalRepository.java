package AssessmentJournal.BusinessLogic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import AssessmentJournal.Data.Grade;

@Repository
public interface AssessmentJournalRepository extends MongoRepository<Grade, String> {

}
