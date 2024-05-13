package com.project.loanservice.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.exception.ErrorCode;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Organization {

    NONE("00000"),
    ORGANIZATION_ONE("00001"),
    ORGANIZATION_TWO("00002");

    @JsonValue
    private final String code;

    Organization(String code) {
        this.code = code;
    }

    public static Organization fromCode(String code) {
        return Arrays.stream(Organization.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst()
                .orElseThrow(() ->
                        new CustomServiceException(ErrorCode.ORGANIZATION_NOT_FOUND));
    }


    @Override
    public String toString() {
        return this.name();
    }
}
