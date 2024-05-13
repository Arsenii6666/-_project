package ClassroomLogin.BusinessLogic;

import com.fasterxml.jackson.databind.JsonSerializer;

import ClassroomLogin.BusinessLogic.ClientProfileRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassroomLogin {

    @Autowired
    private ClientProfileRepository clientProfileRepository;

    @Autowired
    private CourseRepository courseRepository;

    public ClassroomLogin(ClientProfileRepository clientProfileRepository, CourseRepository courseRepository) {
        this.clientProfileRepository = clientProfileRepository;
        this.courseRepository = courseRepository;
    }

    public ClientProfile getClientProfileByLogin(String login, String password) {
        Optional<ClientProfile> clientProfileOptional = clientProfileRepository.findByLogin(login);
        if (clientProfileOptional.isPresent()) {
            ClientProfile clientProfile = clientProfileOptional.get();
            if (!clientProfile.getPassword().equals(password)) {
                System.err.println("ERROR : BAD CLIENT PASSWORD " + password);
                System.err.println("MUST BE NEXT : " + clientProfile.getPassword());
                return null;
            }
            return clientProfile;
        } else {
            System.err.println("ERROR : BAD CLIENT LOGIN " + login);
            return null;
        }
    }

    public void createCourse(String courseName) {
        courseRepository.save(new Course(courseName));
        System.out.println("Course saved: " + courseName);
    }

    public void addClientProfile(ClientProfile clientProfile) {
        clientProfileRepository.save(clientProfile);
    }

    public void addUserToCourse(String courseName, String userName) {
        Optional<Course> courseOptional = courseRepository.findByCourseName(courseName);
        Optional<ClientProfile> clientProfileOptional = clientProfileRepository.findByLogin(userName);
        if (courseOptional.isPresent() && clientProfileOptional.isPresent()) {
            Course course = courseOptional.get();
            ClientProfile user = clientProfileOptional.get();
            user.getCourses().add(course);
            clientProfileRepository.save(user);
        } else {
            System.err.println("Course or user not found.");
        }
    }

    public Course getCourseByName(String courseName) {
        Optional<Course> courseOptional = courseRepository.findByCourseName(courseName);
        return courseOptional.orElse(null);
    }
}
