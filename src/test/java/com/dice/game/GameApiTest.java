package com.dice.game;

import com.dice.game.assertion.DaceAssertion;
import com.dice.game.bo.DiceGameBO;
import com.dice.game.model.DaceResponseModel;
import com.dice.game.util.DaceResponseParser;
import com.dice.game.util.TestListener;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class GameApiTest {

    @Test
    public void testRollDicePositive() {
        DiceGameBO diceGameBO = new DiceGameBO();
        String response = diceGameBO.rollDice(HttpStatus.SC_OK);
        int result = Integer.parseInt(response);
        boolean isCorrect = result >= 1 && result <= 6;
        Assert.assertTrue(isCorrect, "Return incorrect result: " + result);
    }

    @Test(dataProvider = "rollsPositive")
    public void testRollDicePositive1( int dices, int faces, int rolls ) {
        DiceGameBO diceGameBO = new DiceGameBO();
        String response = diceGameBO.rollDices(dices,faces,rolls,HttpStatus.SC_OK);
        DaceResponseModel model = DaceResponseParser.getParsedResponse(response);
        DaceAssertion.assertionFaces(model,faces);
    }

    @Test(dataProvider = "rollsNegativeDices")
    public void testDicesNegative(int dices, int fases, int rolls ){
        DiceGameBO diceGameBO = new DiceGameBO();
        String response = diceGameBO.rollDices(dices,fases,rolls,HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response,"Bad request. Dices amount should be in range [1-100]");


    }
    @Test(dataProvider = "rollsNegativeFaces")
    public void testFacesNegative(int dices, int fases, int rolls ){
        DiceGameBO diceGameBO = new DiceGameBO();
        String response = diceGameBO.rollDices(dices,fases,rolls,HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response,"Bad request. Faces amount should be in range [1-1000000]");


    }
    @Test(dataProvider = "rollsNegativeRolls")
    public void testRollsNegative(int dices, int fases, int rolls ){
        DiceGameBO diceGameBO = new DiceGameBO();
        String response = diceGameBO.rollDices(dices,fases,rolls,HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response,"Bad request. Rolls amount should be in range [1-100000]");


    }

    @DataProvider
    public Object[][] rollsPositive() {
        return new Object[][]{
                {1,6,5},
                {3,2,6},
                {5,6,1},
                {6,5,100000}
        };
    }
    @DataProvider
    public Object[][] rollsNegativeDices() {
        return new Object[][]{
                {0,5,6},
                {101,5,6}
        };
    }
    @DataProvider
    public Object[][] rollsNegativeFaces() {
        return new Object[][]{
                {3,0,6},
                {3,1000001,6}
        };
    }
    @DataProvider
    public Object[][] rollsNegativeRolls() {
        return new Object[][]{
                {3,5,0},
                {3,5,100001}
        };
    }
}