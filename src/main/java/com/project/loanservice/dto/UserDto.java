package com.project.loanservice.dto;

import com.project.loanservice.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String userKey;

    private String userRegNum;

    private String userName;

    private Long userIncAmount;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userKey(userKey)
                .userName(userName)
                .userIncAmount(userIncAmount)
                .userRegNum(userRegNum)
                .build();
    }

    public static UserDto fromEntity(UserEntity userEntity) {
        return UserDto.builder()
                .userKey(userEntity.getUserKey())
                .userRegNum(userEntity.getUserRegNum())
                .userName(userEntity.getUserName())
                .userIncAmount(userEntity.getUserIncAmount())
                .build();
    }

    public static UserDto fromUserInfoInput(UserInfoInput input, String userKey) {
        return UserDto.builder()
                .userKey(userKey)
                .userRegNum(input.getUserRegistrationNumber())
                .userName(input.getUserName())
                .userIncAmount(input.getUserIncomeAmount())
                .build();
    }


}
