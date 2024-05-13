package Gateway.Presentation.TestToSend;

import TestChecker.Data.Test;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatedTests {
    @Getter
    static TestFormat teacherTest;
    @Getter
    List<TestFormat> studentsAnswers;

    public CreatedTests() {
        List<String> europeanCapitals = Arrays.asList(
                "Berlin", "Paris", "Rome", "Madrid", "London",
                "Moscow", "Athens", "Lisbon", "Vienna", "Amsterdam"
        );
        this.teacherTest = new TestFormat("European Capitals Quiz", "Teacher", true, europeanCapitals);
        this.studentsAnswers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> answers = generateStudentAnswers();
            TestFormat studentTest = new TestFormat("European Capitals Quiz", "Student" + (i + 1), false, answers);
            this.studentsAnswers.add(studentTest);
        }
    }

    private List<String> generateStudentAnswers() {
        List<String> answers = new ArrayList<>();
        List<String> europeanCapitals = Arrays.asList(
                "Berlin", "Paris", "Rome", "Madrid", "London",
                "Moscow", "Athens", "Lisbon", "Vienna", "Amsterdam"
        );
        for (int i = 0; i < europeanCapitals.size(); i++) {
            if (Math.random() < 0.2) {
                int randomIndex = (int) (Math.random() * europeanCapitals.size());
                answers.add(europeanCapitals.get(randomIndex));
            } else {
                answers.add(europeanCapitals.get(i));
            }
        }
        return answers;
    }
}
