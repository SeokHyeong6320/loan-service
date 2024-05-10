package com.project.loanservice.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseStatusList {

    SUCCESS("00", "success"),
    FAIL("01", "fail");

    private final String code;
    private final String message;

    ResponseStatusList(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
