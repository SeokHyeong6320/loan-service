package com.project.loanservice.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    PRODUCT_NOT_FOUND("couldn't find product"),
    USER_NOT_FOUND("couldn't find user"),
    ORGANIZATION_NOT_FOUND("couldn't find organization"),
    USER_REG_NUM_DUPLICATED("user registration number is duplicated"),

    RETURNVALUE_INVALID("returnValue is invalid"),

    CYPHER_GENERATING_FAIL("occur error during generate Cipher"),

    ENCRYPT_FAIL("occur error during encrypt"),
    DECRYPT_FAIL("occur error during decrypt");


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
