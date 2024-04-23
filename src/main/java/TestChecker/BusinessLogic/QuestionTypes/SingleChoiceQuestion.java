package TestChecker.BusinessLogic.QuestionTypes;

import java.util.HashMap;

// Class representing a SingleChoiceQuestion question
public class SingleChoiceQuestion extends MultipleChoiceQuestion {

    public SingleChoiceQuestion(String text, HashMap<String, TrueFalseClear> correctOptions) {
        super(text, correctOptions);
    }
//    private final String[] options;
//    private final int correctOption;
//
//    // Constructor
//    public SingleChoiceQuestion(String text, String[] options, int correctOption) {
//        super(text);
//        this.options = options;
//        this.correctOption = correctOption;
//    }
//
//    // Method to display the question
//    @Override
//    public void display() {
//        super.display();
//        for (int i = 0; i < options.length; i++) {
//            System.out.println(STR."\{i + 1}. \{options[i]}");
//        }
//    }
//
//    // Method to check the answer
//    public int gradeAnswer(SingleChoiceQuestion answer) {
//        return correctOption == answer.correctOption ? 1 : 0;
//    }
}
