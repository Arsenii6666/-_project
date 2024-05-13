package TestChecker.Presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import AssessmentJourmal.Presentation.
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"TestChecker.BusinessLogic", "TestChecker.Presentation"})
@EnableJpaRepositories(basePackages="TestChecker.BusinessLogic")
@EntityScan(basePackages = {"AssessmentJournal.Data", "ClassroomLogin.BusinessLogic", "TestChecker.Data"}) 
public class TestCheckerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestCheckerApplication.class, args);
    }
}
