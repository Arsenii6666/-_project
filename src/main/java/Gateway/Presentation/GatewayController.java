package Gateway.Presentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class GatewayController {
    @Value("${classroom-login.url}")
    private String classroomLoginUrl;
    private final String classroomLoginBaseUrl = "http://localhost:8080"; // Адреса ClassroomLogin сервісу
    private final RestTemplate restTemplate;
    public GatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @PostMapping("/new-user")
    public ResponseEntity<?> newUser(@RequestBody Map<String, String> payload) {
        ResponseEntity<?> responseEntity = restTemplate.postForEntity(classroomLoginBaseUrl + "/new-user", payload, String.class);
        System.out.println(responseEntity.getBody());
        return responseEntity;
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUser() {
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(classroomLoginBaseUrl + "/get-user", String.class);
        System.out.println(responseEntity.getBody());
        return responseEntity;
    }

    @PostMapping("/create-course")
    public ResponseEntity<?> createCourse(@RequestBody Map<String, String> payload) {
        ResponseEntity<?> responseEntity = restTemplate.postForEntity(classroomLoginBaseUrl + "/create-course", payload, String.class);
        System.out.println(responseEntity.getBody());
        return responseEntity;
    }

    @PostMapping("/add-to-course")
    public ResponseEntity<?> addToCourse(@RequestBody Map<String, String> payload) {
        ResponseEntity<?> responseEntity = restTemplate.postForEntity(classroomLoginBaseUrl + "/add-to-course", payload, String.class);
        System.out.println(responseEntity.getBody());
        return responseEntity;
    }

    @GetMapping("/get-course/{courseName}")
    public ResponseEntity<?> getCourse(@PathVariable String courseName) {
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(classroomLoginBaseUrl + "/get-course/" + courseName, String.class);
        System.out.println(responseEntity.getBody());
        return responseEntity;
    }
}

