package com.project.loanservice.domain;

import com.project.loanservice.dto.UserDto;
import lombok.Getter;

@Getter
public class UserResponse {

    @Getter
    public static class userKey {
        private final String userKey;

        private userKey(String userKey) {
            this.userKey = userKey;
        }
    }

    @Getter
    public static class privateInfo {
        private final String userKey;
        private final String userRegistrationNumber;

        private privateInfo(String userKey, String userRegistrationNumber) {
            this.userKey = userKey;
            this.userRegistrationNumber = userRegistrationNumber;
        }
    }

    private UserResponse() {
    }

    public static userKey userKey(UserDto userDto) {
        return new userKey(userDto.getUserKey());
    }

    public static privateInfo privateInfo(UserDto userDto) {
        return new privateInfo(
                userDto.getUserKey(), userDto.getUserRegNum()
        );
    }
}
