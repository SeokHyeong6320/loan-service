package com.project.loanservice.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.project.loanservice.response.ResponseStatusList.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseStatus {

    private final String responseCode;
    private final String responseMessage;

    public static ResponseStatus onSuccess() {
        return new ResponseStatus(SUCCESS.getCode(), SUCCESS.getMessage());
    }

    public static ResponseStatus onFail() {
        return new ResponseStatus(FAIL.getCode(), FAIL.getMessage());
    }
}
