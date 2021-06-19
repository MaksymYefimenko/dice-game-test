package com.dice.game.client;


import io.restassured.response.Response;

public abstract class Client<T> {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    protected abstract T getType();

    public T verifyStatusCode(int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
        return getType();
    }

}
