package com.dice.game.bo;

import com.dice.game.client.DiceGameClient;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiceGameBO {
    private static final Logger LOG = LogManager.getLogger(DiceGameBO.class);

    public String rollDice(int expectedStatusCode) {
        LOG.info("Call roll dice, verify status code");
        DiceGameClient client = new DiceGameClient();
        String body = client.rollDice().verifyStatusCode(expectedStatusCode).getRollDiceResponse();
        return body;
    }

    public String rollDices(int dices, int faces, int rolls, int expectedStatusCode) {
        LOG.info("Call roll dices,");
        DiceGameClient client = new DiceGameClient();
         String body = client.rollDices(dices,faces,rolls ).verifyStatusCode(expectedStatusCode).getRollDiceResponse();
         return body;

    }
}
