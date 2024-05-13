package AssessmentJournal.Presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import AssessmentJournal.BusinessLogic.MongoConfig;

@SpringBootApplication
@ComponentScan(basePackages = {"AssessmentJournal.BusinessLogic", "AssessmentJournal.Presentation", "AssessmentJournal.Data"})
@EnableMongoRepositories(basePackages = {"AssessmentJournal.Data", "AssessmentJournal.BusinessLogic"})
@Import(MongoConfig.class)
public class AssessmentJournalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssessmentJournalApplication.class, args);
    }
}
