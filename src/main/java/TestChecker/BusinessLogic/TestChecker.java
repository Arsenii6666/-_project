package TestChecker.BusinessLogic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestChecker {
    Map<String, List<String>> tests= new HashMap<>();
    public String submit(String data) {
        String[] lines = data.split("\n");
        if (lines[2].equals("Is From Teacher: true")) {
            String testName = lines[0];
            List<String> answers = List.of(lines).subList(3, lines.length);
            tests.put(testName, answers);
            return "Teacher's test saved";
        } else {
            String testName = lines[0];
            List<String> studentAnswers = List.of(lines).subList(3, lines.length);
            if (!tests.containsKey(testName)) {
                return "Test not found";
            }
            List<String> teacherAnswers = tests.get(testName);
            int correctCount = 0;
            for (int i = 0; i < studentAnswers.size(); i++) {
                if (studentAnswers.get(i).equals(teacherAnswers.get(i))) {
                    correctCount++;
                }
            }
            return "Correct answers: " + correctCount + " out of " + studentAnswers.size();
        }
    }
}
