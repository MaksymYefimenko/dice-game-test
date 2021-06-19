package com.dice.game.util;

import com.dice.game.model.DaceResponseModel;

import java.util.Arrays;
import java.util.List;

public class DaceResponseParser {
    public static DaceResponseModel getParsedResponse(String body){
        return new DaceResponseModel().setRollResult(body.split("\\n"));
    }


}
  //  public static DaceResponseModel getParsedResponse(String body){
    //    List<String> results = Arrays.asList(body.split("\\n"));
      //  DaceResponseModel model = new DaceResponseModel();
        //model.setRollResult(results);
        //return model;