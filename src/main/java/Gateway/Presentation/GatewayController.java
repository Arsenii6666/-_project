package Gateway.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/")
public class GatewayController {

    private final RestTemplate restTemplate = new RestTemplate();;
    private final String classroomLoginBaseUrl = "http://localhost:8080";

    @PostMapping("/new-user")
    public String newUser(@RequestBody Map<String, String> payload) {
        ResponseEntity<?> responseEntity = restTemplate.postForEntity(classroomLoginBaseUrl + "/new-user", payload, String.class);
        return responseEntity.getBody().toString();
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUser() {
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(classroomLoginBaseUrl + "/get-user", String.class);
        return responseEntity;
    }

    @PostMapping("/create-course")
    public String createCourse(@RequestBody Map<String, String> payload) {
        ResponseEntity<?> responseEntity = restTemplate.postForEntity(classroomLoginBaseUrl + "/create-course", payload, String.class);
        return responseEntity.getBody().toString();
    }

    @PostMapping("/add-to-course")
    public String addToCourse(@RequestBody Map<String, String> payload) {
        ResponseEntity<?> responseEntity = restTemplate.postForEntity(classroomLoginBaseUrl + "/add-to-course", payload, String.class);
        return responseEntity.getBody().toString();
    }

    @GetMapping("/get-course/{courseName}")
    public ResponseEntity<?> getCourse(@PathVariable String courseName) {
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(classroomLoginBaseUrl + "/get-course/" + courseName, String.class);
        return responseEntity;
    }
}
