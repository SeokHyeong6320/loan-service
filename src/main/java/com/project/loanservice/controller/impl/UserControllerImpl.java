package com.project.loanservice.controller.impl;

import com.project.loanservice.controller.UserController;
import com.project.loanservice.domain.UserResponse;
import com.project.loanservice.dto.UserDto;
import com.project.loanservice.dto.UserInfoInput;
import com.project.loanservice.response.DataResponse;
import com.project.loanservice.response.ResponseStatus;
import com.project.loanservice.service.UserService;
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
    public ResponseEntity<DataResponse> obtainUserInfo(
            @RequestBody UserInfoInput input
    ) {

        UserDto userDto = userService.saveUser(input);

        return ResponseEntity.ok(
                new DataResponse(
                        UserResponse.userKey(userDto),
                        ResponseStatus.onSuccess()
                )
        );
    }

    @Override
    @GetMapping("/private-info/{userKey}")
    public ResponseEntity<DataResponse> getUserInfo(@PathVariable String userKey) {

        UserDto userDto = userService.findUserInfo(userKey);

        return ResponseEntity.ok(
                new DataResponse(
                        UserResponse.privateInfo(userDto),
                        ResponseStatus.onSuccess()
                )
        );
    }


}
