package com.project.loanservice.controller;

import com.project.loanservice.dto.UserInfoInput;
import com.project.loanservice.response.Response;
import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity<Response> obtainUserInfo(UserInfoInput input);

    ResponseEntity<Response> getUserInfo(String userKey);

}
