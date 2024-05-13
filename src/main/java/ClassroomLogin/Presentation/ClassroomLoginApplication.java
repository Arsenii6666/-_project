package ClassroomLogin.Presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collections;

@SpringBootApplication
@ComponentScan(basePackages = {"ClassroomLogin.BusinessLogic", "ClassroomLogin.Presentation"})
@EnableJpaRepositories(basePackages="ClassroomLogin.BusinessLogic")
@EntityScan("ClassroomLogin.BusinessLogic") 
public class ClassroomLoginApplication {
    private static Integer ServerPort;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClassroomLoginApplication.class);
        ServerPort= 8090;
        app.setDefaultProperties(Collections.singletonMap("server.port", ServerPort));
        app.run(args);
    }
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ClassroomLogin is running on port:" + ServerPort);
//        int port = hz.getConfig().getNetworkConfig().getPort();
//        System.out.println("Hazelcast is running on port: " + port);
    }
}
