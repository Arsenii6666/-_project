package Gateway.Presentation;

import ClassroomLogin.Presentation.ClassroomLoginApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class GatewayApplication {

    private static Integer serverPort;
    private static String classroomLoginUrl;

    public static void main(String[] args) {
        serverPort = 8090; // Порт для Gateway сервісу
        classroomLoginUrl = "http://localhost:8080"; // URL ClassroomLogin сервісу

        SpringApplication app = new SpringApplication(GatewayApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", serverPort));
        app.run(args);
    }

    public static String getClassroomLoginUrl() {
        return classroomLoginUrl;
    }
}
