package com.project.loanservice.controller;

import com.project.loanservice.dto.UserInfoInput;
import com.project.loanservice.response.DataResponse;
import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity<DataResponse> obtainUserInfo(UserInfoInput input);

    ResponseEntity<DataResponse> getUserInfo(String userKey);

}
