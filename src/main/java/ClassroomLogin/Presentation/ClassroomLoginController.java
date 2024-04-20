package ClassroomLogin.Presentation;

import ClassroomLogin.BussnessLogic.ClassroomLogin;
import ClassroomLogin.BussnessLogic.ClientProfile;
import ClassroomLogin.BussnessLogic.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class ClassroomLoginController {
    private final ClassroomLogin classroomLogin = new ClassroomLogin();
    @PostMapping("/new-user")
    public String newUser(@RequestBody Map<String, String> payload) {
        String login = payload.get("login");
        String password = payload.get("password");
        String fullName = payload.get("fullName");
        String institution = payload.get("institution");
        String status = payload.get("status");
        String position = payload.get("position");
        ClientProfile clientProfile = new ClientProfile(0, login, password, fullName, institution, status, position, null);
        classroomLogin.addClientProfile(clientProfile);
        return "New user created successfully.";
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(@RequestParam String login, @RequestParam String password) {
        ClientProfile clientProfile = classroomLogin.getClientProfileByLogin(login, password);
        if (clientProfile.getId() == -1) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
        return ResponseEntity.ok().body(clientProfile);
    }
    @PostMapping("/create-course")
    public String createCourse(@RequestBody Map<String, String> payload) {
        String courseName = payload.get("courseName");
        String teacherName = payload.get("teacherName");
        classroomLogin.createCourse(courseName, teacherName);
        return "New course created successfully.";
    }

    @PostMapping("/add-to-course")
    public String addToCourse(@RequestBody Map<String, String> payload) {
        String login = payload.get("login");
        String courseName = payload.get("courseName");
        String UserLogin = payload.get("UserLogin");
        classroomLogin.addUserToCourse(courseName, UserLogin);
        return "User added to course successfully.";
    }
    @GetMapping("/get-course/{courseName}")
    public ResponseEntity<?> getCourse(@PathVariable String courseName) {
        Course course = classroomLogin.getCourseByName(courseName);
        if (course != null) {
            return ResponseEntity.ok().body(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
