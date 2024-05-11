package com.project.loanservice.exception;

import lombok.Getter;

@Getter
public class CustomServiceException extends RuntimeException{

   private final ErrorCode errorCode;

    public CustomServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
