package TestChecker.BusinessLogic.QuestionTypes;

import java.util.Objects;

// Class representing a true/false question
public class TrueFalseQuestion extends Question {
    private TrueFalseClear correctAnswer;
    // Constructor
    public TrueFalseQuestion(String text, TrueFalseClear correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    // Method to display the question
    @Override
    public void display() {
        super.display();
        System.out.println("1. True");
        System.out.println("2. False");
        System.out.println();
    }

    public void clear(){
        correctAnswer = TrueFalseClear.Clear;
    }
    public int gradeAnswer(TrueFalseQuestion answer) {
        return answer.correctAnswer == correctAnswer ? 1 : 0;
    }

    public boolean equals(MultipleChoiceQuestion answer){
        return Objects.equals(question, answer.question);
    }
}
