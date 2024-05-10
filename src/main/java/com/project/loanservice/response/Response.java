package com.project.loanservice.response;

import lombok.Getter;


@Getter
public class Response {

    private final Object data;

    private final String responseCode;
    private final String responseMessage;


    public Response(Object data, ResponseStatus status) {
        this.data = data;
        this.responseCode = status.getResponseCode();
        this.responseMessage = status.getResponseMessage();
    }
}



