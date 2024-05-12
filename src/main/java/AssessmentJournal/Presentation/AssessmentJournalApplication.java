package AssessmentJournal.Presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"AssessmentJournal.BusinessLogic", "AssessmentJournal.Presentation"})
public class AssessmentJournalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssessmentJournalApplication.class, args);
    }
}
