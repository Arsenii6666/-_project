package TestChecker.BusinessLogic;

import TestChecker.BusinessLogic.QuestionTypes.MultipleChoiceQuestion;
import TestChecker.BusinessLogic.QuestionTypes.SingleChoiceQuestion;
import TestChecker.BusinessLogic.QuestionTypes.TrueFalseClear;
import TestChecker.BusinessLogic.QuestionTypes.TrueFalseQuestion;

import java.util.HashMap;
import java.util.Map;


//TODO: add command line parsing for question answering (CLI)

public class Test {

    private Integer id = 0;

    //    enum TaskType{
//        TRUE_FALSE,
//        SINGLE_ANSWER,
//        MULTIPLE_ANSWERS
//    }
//    HashMap<Integer, TaskType> allTasksTypes;
    public HashMap<Integer, TrueFalseQuestion> trueFalseQuestions = new HashMap<>();
    public HashMap<Integer, SingleChoiceQuestion> singleChoiceQuestions = new HashMap<>();
    public HashMap<Integer, MultipleChoiceQuestion> multipleChoiceQuestions = new HashMap<>();


    public boolean equals(Test other) {
        return trueFalseQuestions.keySet().equals(other.trueFalseQuestions.keySet())
                && singleChoiceQuestions.keySet().equals(other.singleChoiceQuestions.keySet())
                && multipleChoiceQuestions.keySet().equals(other.multipleChoiceQuestions.keySet());
    }

    public String checkTest(Test studentTest) {
        if (!this.equals(studentTest)) {
            return "Error : this test and student tests are not equal";
        }
        int grade = 0;

        for (Map.Entry<Integer, TrueFalseQuestion> pair : studentTest.trueFalseQuestions.entrySet()) {
            grade += trueFalseQuestions.get(pair.getKey()).gradeAnswer(pair.getValue());
        }
        for (Map.Entry<Integer, SingleChoiceQuestion> pair : studentTest.singleChoiceQuestions.entrySet()) {
            grade += singleChoiceQuestions.get(pair.getKey()).gradeAnswer(pair.getValue());
        }
        for (Map.Entry<Integer, MultipleChoiceQuestion> pair : studentTest.multipleChoiceQuestions.entrySet()) {
            grade += multipleChoiceQuestions.get(pair.getKey()).gradeAnswer(pair.getValue());
        }
        return STR."\{grade}";
    }

    public Test clearAnswers() {
        for (Map.Entry<Integer, TrueFalseQuestion> pair : trueFalseQuestions.entrySet()) {
            pair.getValue().clear();
        }
        for (Map.Entry<Integer, SingleChoiceQuestion> pair : singleChoiceQuestions.entrySet()) {
            pair.getValue().clear();
        }
        for (Map.Entry<Integer, MultipleChoiceQuestion> pair : multipleChoiceQuestions.entrySet()) {
            pair.getValue().clear();
        }
        return this;
    }

    public void displayQuestions() {
        for (Map.Entry<Integer, TrueFalseQuestion> pair : trueFalseQuestions.entrySet()) {
            pair.getValue().display();
        }
        for (Map.Entry<Integer, SingleChoiceQuestion> pair : singleChoiceQuestions.entrySet()) {
            pair.getValue().display();
        }
        for (Map.Entry<Integer, MultipleChoiceQuestion> pair : multipleChoiceQuestions.entrySet()) {
            pair.getValue().display();
        }
        return;
    }

    Test addQuestion(TrueFalseQuestion q) {
        trueFalseQuestions.put(++id, q);
        return this;
    }

    Test addQuestion(SingleChoiceQuestion q) {
        singleChoiceQuestions.put(++id, q);
        return this;
    }

    Test addQuestion(MultipleChoiceQuestion q) {
        multipleChoiceQuestions.put(++id, q);
        return this;
    }


    // Main function for testing
    public static void main(String[] args) {
        // Example usage
        Test mathTest = new Test();

        mathTest.addQuestion(new TrueFalseQuestion(
                        "Is 308310668521573408703013357419356551707 a prime number?",
                        TrueFalseClear.False
                )
        );

        mathTest.addQuestion(new SingleChoiceQuestion(
                        "What is 2 + 2?",
                        new HashMap<String, TrueFalseClear>() {{
                            put("4", TrueFalseClear.True);
                            put("5", TrueFalseClear.False);
                            put("6", TrueFalseClear.False);
                            put("7", TrueFalseClear.False);
                        }}
                )
        );

        mathTest.addQuestion(new MultipleChoiceQuestion(
                        "What is 2 + 2?",
                        new HashMap<String, TrueFalseClear>() {{
                            put("4", TrueFalseClear.True);
                            put("5", TrueFalseClear.False);
                            put("6", TrueFalseClear.False);
                            put("7", TrueFalseClear.False);
                        }}
                )
        );


        mathTest.addQuestion(new MultipleChoiceQuestion(
                        "What are roots of x^2 = 1024?",
                        new HashMap<String, TrueFalseClear>() {{
                            put("512", TrueFalseClear.False);
                            put("-512", TrueFalseClear.False);
                            put("32", TrueFalseClear.True);
                            put("-32", TrueFalseClear.True);
                        }}
                )
        );

//        mathTest.addQuestion(new TrueFalseQuestion("Is 3 a prime number?", true));

        mathTest.displayQuestions();
//        mathTest.displayInstructions();
//        mathTest.conductTest();
//        mathTest.gradeTest();
    }

}

