package com.project.loanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInput {

    private String organizationCode;
    private String productCode;
    private String productMaximumInterest;
    private String productMinimumInterest;
    private String productName;
}
