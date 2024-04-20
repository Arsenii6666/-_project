package ClassroomLogin.BussnessLogic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Course {
    private String courseName;
    private List<String> students;
    private List<String> teachers;
    private List<String> tests;

    public Course(String courseName, String teacher) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        teachers.add(teacher);
        this.tests = new ArrayList<>();
    }

    public void addTeacher(String teacherName) {

    }

    public void addStudent(String userName) {

    }
}
