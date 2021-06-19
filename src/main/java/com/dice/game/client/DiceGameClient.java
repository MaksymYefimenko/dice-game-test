package com.dice.game.client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import java.util.Arrays;

import static com.dice.game.data.DiceGameConstans.BASE_URL;
import static io.restassured.RestAssured.given;

public class DiceGameClient extends Client<DiceGameClient> {
    public DiceGameClient rollDice() {
        setResponse(
                given()
                        .baseUri(BASE_URL)
                        .filters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                        .accept(ContentType.TEXT)
                        .get("/api/roll"));
        return this;
    }

    public DiceGameClient rollDices(int dices, int faces, int rolls) {
        setResponse(
                given()
                        .baseUri(BASE_URL)
                        .filters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                        .accept(ContentType.TEXT)
                        .queryParam("dices", dices)
                        .queryParam("faces", faces)
                        .queryParam("rolls", rolls)
                        .get("/api/roll"));
        return this;
    }

    public String getRollDiceResponse() {
        String body = getResponse().getBody().asString();
        return body;

    }

    @Override
    protected DiceGameClient getType() {
        return this;
    }
}
