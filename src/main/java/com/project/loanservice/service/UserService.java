package com.project.loanservice.service;

import com.project.loanservice.dto.UserDto;
import com.project.loanservice.dto.UserInfoInput;

public interface UserService {
    UserDto saveUser(UserInfoInput input);

    UserDto findUserInfo(String userKey);
}
