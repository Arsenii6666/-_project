package TestChecker.BusinessLogic.QuestionTypes;

import java.util.HashMap;
import java.util.Map;

// Class representing a multiple choice question
public class MultipleChoiceQuestion extends Question {
//    private final String[] options;


    protected HashMap<String, TrueFalseClear> correctOptions;

    // Constructor
    public MultipleChoiceQuestion(String text, HashMap<String, TrueFalseClear> correctOptions) {
        super(text);
        this.correctOptions = correctOptions;
    }

    // Method to display the question
    @Override
    public void display() {
        super.display();

        int i = 0;
        for (Map.Entry<String, TrueFalseClear> pair : correctOptions.entrySet()) {
            System.out.println(STR."\{i + 1}. \{pair.getKey()}");
            ++i;
        }
        System.out.println();
    }
    public void clear(){
        for (Map.Entry<String, TrueFalseClear> pair : correctOptions.entrySet()) {
            correctOptions.replace(pair.getKey(), TrueFalseClear.Clear);
        }
    }
    // Method to check the answer
    public int gradeAnswer(MultipleChoiceQuestion answer) {
        return correctOptions == answer.correctOptions ? 1 : 0;
    }

    public boolean equals(MultipleChoiceQuestion answer){
        return correctOptions.keySet() == answer.correctOptions.keySet();
    }
}
