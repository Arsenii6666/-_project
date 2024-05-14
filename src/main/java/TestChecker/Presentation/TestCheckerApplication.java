package TestChecker.Presentation;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
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
    public static HazelcastInstance hz;
    public static void main(String[] args) {
        connectToTestQueue();
        SpringApplication.run(TestCheckerApplication.class, args);
    }
    static void connectToTestQueue(){
        Config TestQueueConfig = new Config();
        TestQueueConfig.setClusterName("TestQueue");
        TestQueueConfig.getNetworkConfig().setPort(5702);
        TestQueueConfig.getNetworkConfig().getRestApiConfig().setEnabled(true);
        hz = Hazelcast.newHazelcastInstance(TestQueueConfig);
    }
}
