package com.project.loanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoInput {

    private String userIncomeAmount;
    private String userName;
    private String userRegistrationNumber;

}
