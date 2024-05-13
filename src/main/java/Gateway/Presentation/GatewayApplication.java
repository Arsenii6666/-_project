package Gateway.Presentation;

import ClassroomLogin.Presentation.ClassroomLoginApplication;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class GatewayApplication {

    private static Integer serverPort;
    private static String classroomLoginUrl;
    public static HazelcastInstance hz;

    public static void main(String[] args) {
        serverPort = 8090;
        classroomLoginUrl = "http://localhost:8080";
        SpringApplication app = new SpringApplication(GatewayApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", serverPort));
        connectToTestQueue();
        app.run(args);
    }

    public static String getClassroomLoginUrl() {
        return classroomLoginUrl;
    }
    static void connectToTestQueue(){
        Config TestQueueConfig = new Config();
        TestQueueConfig.setClusterName("TestQueue");
        TestQueueConfig.getNetworkConfig().setPort(5702);
        TestQueueConfig.getNetworkConfig().getRestApiConfig().setEnabled(true);
        hz = Hazelcast.newHazelcastInstance(TestQueueConfig);
    }
}
