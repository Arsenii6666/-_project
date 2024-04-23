package TestChecker.Data;

import TestChecker.BusinessLogic.Test;

import java.util.ArrayList;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

//TODO : local logging
public class TestDataBase {

    ConcurrentHashMap<String, Test> dataBase;
    ArrayList<String> log;

    public String addTest(UUID user_id,
                          String testName,
                          Test testBody) {

        String result;

        if (dataBase.putIfAbsent(testName, testBody) == null) {
            result = "fail";
        } else {
            result = "success";
        }
        log.add(STR."addTest(user_id = \{user_id}, testName = \{testName}, testBody = \{testBody}) == \{result}");
        return result;
    }

    public Test getTest(UUID user_id,
                        String testName) {
        String result;
        Test test = dataBase.get(testName);

        if (test == null) {
            result = "fail";
            test = new Test();
        } else {
            result = "success";
        }
        log.add(STR."getTest(user_id = \{user_id}, testName = \{testName}) == \{result}");
        return test;
    }

}