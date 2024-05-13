package Gateway.Presentation.TestToSend;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TestFormat {
    String testName;
    String userName;
    Boolean isFromTeacher;
    List<String> answers;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test Name: ").append(testName).append("\n");
        sb.append("User Name: ").append(userName).append("\n");
        sb.append("Is From Teacher: ").append(isFromTeacher).append("\n");
        sb.append("Answers: ").append(answers).append("\n");
        return sb.toString();
    }
}
