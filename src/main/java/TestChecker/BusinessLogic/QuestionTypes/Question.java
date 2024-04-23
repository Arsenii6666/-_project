package TestChecker.BusinessLogic.QuestionTypes;


// Abstract class representing a generic question
public abstract class Question {
    protected String question;

    // Constructor
    public Question(String text) {
        this.question = STR."\{text}";
    }

    // Method to display the question
    public void display() {
        System.out.println(question);
    }

    public abstract void clear();

    // Abstract method to check the answer
//    public abstract boolean checkAnswer(Question answer);
}

