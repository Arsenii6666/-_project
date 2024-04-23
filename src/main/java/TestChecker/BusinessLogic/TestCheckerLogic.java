package TestChecker.BusinessLogic;

import TestChecker.Data.TestDataBase;

import java.util.UUID;

public class TestCheckerLogic {

    TestDataBase db;

    public String addTest(UUID user_id,
                          String testName,
                          Test testBody) {
        String if_success = db.addTest(user_id, testName, testBody);
        return if_success;
    }

    public String checkTest(UUID user_id,
                            String testName,
                            Test studentTest) {
        Test rightAnswers = db.getTest(user_id, testName);
        String if_success = rightAnswers.checkTest(studentTest);
        return if_success;
    }

    public Test getTestNoAnswers(UUID user_id,
                                 String testName) {

        return db.getTest(user_id, testName).clearAnswers();

    }
}
