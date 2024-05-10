package com.project.loanservice.controller.impl;

import com.project.loanservice.controller.UserController;
import com.project.loanservice.dto.UserInfoInput;
import com.project.loanservice.response.Response;
import com.project.loanservice.response.ResponseStatus;
import com.project.loanservice.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fintech/v1/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @PostMapping("/information")
    public ResponseEntity<Response> obtainUserInfo(
            @RequestBody UserInfoInput input
            ) {

        return ResponseEntity.ok(null);
    }

    @Override
    @GetMapping("/private-info/{userKey}")
    public ResponseEntity<Response> getUserInfo(@PathVariable String userKey) {

        return ResponseEntity.ok(null);
    }


}
