package com.project.loanservice.domain;

import com.project.loanservice.exception.CustomServiceException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Organization {

    ORGANIZATION_ONE("00001"),
    ORGANIZATION_TWO("00002");



    private final String code;

    Organization(String code) {
        this.code = code;
    }

    public static Organization fromCode(String code) {
        return Arrays.stream(Organization.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst()
                .orElseThrow(() ->
                        new CustomServiceException("couldn't find Organization"));
    }
}
