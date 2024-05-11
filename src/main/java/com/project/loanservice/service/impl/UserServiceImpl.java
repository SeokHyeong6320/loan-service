package com.project.loanservice.service.impl;

import com.project.loanservice.domain.UserEntity;
import com.project.loanservice.dto.UserDto;
import com.project.loanservice.dto.UserInfoInput;
import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.exception.ErrorCode;
import com.project.loanservice.repository.UserRepository;
import com.project.loanservice.service.KeyUtil;
import com.project.loanservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KeyUtil keyUtil;

    @Override
    @Transactional
    public UserDto saveUser(UserInfoInput input) {

        if (userRepository.existsByUserRegNum
                (input.getUserRegistrationNumber())) {
            throw new CustomServiceException(ErrorCode.USER_REG_NUM_DUPLICATED);
        }

        String userKey = keyUtil.generateUserKey();
        UserDto userDto = UserDto.fromUserInfoInput(input, userKey);

        userRepository.save(userDto.toEntity());

        return userDto;
    }

    @Override
    public UserDto findUserInfo(String userKey) {
        UserEntity findUser = userRepository.findByUserKey(userKey)
                .orElseThrow(() -> new CustomServiceException
                        (ErrorCode.USER_NOT_FOUND));

        return UserDto.fromEntity(findUser);
    }
}
