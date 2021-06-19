package com.dice.game.assertion;

import com.dice.game.model.DaceResponseModel;
import org.testng.asserts.SoftAssert;

import static com.dice.game.data.DiceGameConstans.MIN_NUMBER;

public class DaceAssertion {
    public static void assertionFaces(DaceResponseModel model, int faces){
        SoftAssert softAssert = new SoftAssert();
        for (String currentNumbers : model.getRollResult()) {
            String[] current = currentNumbers.split(" ");
            for (String number : current){
                int result = Integer.parseInt(number);
                boolean isCorrect = result >= MIN_NUMBER && result <= faces;
                softAssert.assertTrue(isCorrect, "Incorrect result: " + result);
            }
        }
        softAssert.assertAll();
    }
}
