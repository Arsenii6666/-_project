package ClassroomLogin.BussnessLogic;

import com.fasterxml.jackson.databind.JsonSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ClassroomLogin {
    private Map<String, ClientProfile> clientProfiles;
    private Map<String, Course> courses;

    public ClassroomLogin() {
        this.clientProfiles = new HashMap<>();
        this.courses = new HashMap<>();
        addClientProfile(new ClientProfile(1, "john_doe", "password123", "John Doe", "Example University", "student", "", new ArrayList<>()));
        createCourse("Mathematics", "Teacher1");
    }

    public ClientProfile getClientProfileByLogin(String login, String password) {
        if (!clientProfiles.containsKey(login)){
            return new ClientProfile(-1, "No user with this login");
        }
        if (clientProfiles.get(login).getPassword()!=password){
            return new ClientProfile(-1, "Wrong password");
        }
        return clientProfiles.get(login);
    }

    public void createCourse(String courseName, String teacherName) {
        Course course = new Course(courseName, teacherName);
        courses.put(courseName, course);
        System.out.println("Course saved: " + courseName);
    }
    public void addClientProfile(ClientProfile clientProfile) {
        clientProfiles.put(clientProfile.getLogin(), clientProfile);
    }
    public void addUserToCourse(String courseName, String userName) {
        Course course=courses.get(courseName);
        ClientProfile user = clientProfiles.get(userName);
        String userType = user.getStatus();
        if (userType.equals("student")) {
            course.addStudent(userName);
        } else if (userType.equals("teacher")) {
            course.addTeacher(userName);
        }
        clientProfiles.get(userName).addCourse(course);
    }

    public Course getCourseByName(String courseName) {
        return courses.get(courseName);
    }
}
