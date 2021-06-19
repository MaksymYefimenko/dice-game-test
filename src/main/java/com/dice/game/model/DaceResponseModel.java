package com.dice.game.model;

import java.util.Arrays;
import java.util.List;

public class DaceResponseModel {
    private List<String> rollResult;

    public List<String> getRollResult() {
        return rollResult;
    }

    public DaceResponseModel setRollResult(String[] rollResult) {
        this.rollResult = Arrays.asList(rollResult);
        return this;
    }

}
