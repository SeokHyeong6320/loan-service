package com.project.loanservice.service.impl;

import com.project.loanservice.domain.UserEntity;
import com.project.loanservice.dto.UserDto;
import com.project.loanservice.dto.UserInfoInput;
import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.repository.UserRepository;
import com.project.loanservice.service.EncryptUtil;
import com.project.loanservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EncryptUtil encryptUtil;

    @Override
    @Transactional
    public UserDto saveUser(UserInfoInput input) {

        String userKey = encryptUtil.generateUserKey();
        UserDto userDto = UserDto.fromUserInfoInput(input, userKey);

        userRepository.save(userDto.toEntity());

        return userDto;
    }

    @Override
    public UserDto findUserInfo(String userKey) {
        UserEntity findUser = userRepository.findByUserKey(userKey)
                .orElseThrow(() -> new CustomServiceException
                        ("couldn't find UserEntity"));

        return UserDto.fromEntity(findUser);
    }
}
