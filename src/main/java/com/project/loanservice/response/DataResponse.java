package com.project.loanservice.response;

import lombok.Getter;


@Getter
public class DataResponse<T> {

    private final T data;

    private final String responseCode;
    private final String responseMessage;


    public DataResponse(T data, ResponseStatus status) {
        this.data = data;
        this.responseCode = status.getResponseCode();
        this.responseMessage = status.getResponseMessage();
    }
}



