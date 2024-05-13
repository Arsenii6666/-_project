package AssessmentJournal.Presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"AssessmentJournal.BusinessLogic", "AssessmentJournal.Presentation", "AssessmentJournal.Data"})
@EnableJpaRepositories(basePackages="AssessmentJournal.BusinessLogic")
@EntityScan(basePackages = {"AssessmentJournal.Data", "ClassroomLogin.BusinessLogic", "TestChecker.Data"}) 
public class AssessmentJournalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssessmentJournalApplication.class, args);
    }
}
