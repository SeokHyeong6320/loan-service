package com.project.loanservice.domain;

import com.project.loanservice.exception.CustomServiceException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Product {

    PROD_1("상품 1", "00001"),
    PROD_2("상품 2", "00002");

    private final String name;
    private final String code;

    Product(String productName, String productCode) {
        this.name = productName;
        this.code = productCode;
    }

    public static Product fromName(String productName) {
        return Arrays.stream(Product.values())
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() ->
                        new CustomServiceException("couldn't find Product"));
    }

    public static Product fromCode(String productCode) {
        return Arrays.stream(Product.values())
                .filter(p -> p.getCode().equals(productCode))
                .findFirst()
                .orElseThrow(() ->
                        new CustomServiceException("couldn't find Product"));
    }
}
