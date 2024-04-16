package ClassroomLogin.BussnessLogic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class Course {
    private String courseName;
    private List<String> students;
    private List<String> teachers;
    private List<String> tests;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.tests = new ArrayList<>();
    }
}
