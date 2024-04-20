package ClassroomLogin.BussnessLogic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientProfile {
    private int id;
    private String login;
    private String password;
    private String fullName;
    private String institution;
    private String status;
    private String position;
    private List<Course> courses;
    ClientProfile (int error, String description){
        id = error;
        login=description;
    }
    void addCourse(Course course){
        courses.add(course);
    }
}
