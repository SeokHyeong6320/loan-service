package com.project.loanservice.response;

import com.project.loanservice.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String errorCode;
    private final String errorMessage;
    private final String responseCode;
    private final String responseMessage;

    public ErrorResponse(ErrorCode errorCode, ResponseStatus status) {
        this.errorCode = errorCode.toString();
        this.errorMessage = errorCode.getMessage();
        this.responseCode = status.getResponseCode();
        this.responseMessage = status.getResponseMessage();
    }
}
