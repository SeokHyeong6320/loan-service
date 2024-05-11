package com.project.loanservice.domain;

import com.project.loanservice.dto.UserDto;
import lombok.Getter;

@Getter
public class UserResponse {

    @Getter
    public static class enroll {
        private final String userKey;

        private enroll(String userKey) {
            this.userKey = userKey;
        }
    }

    @Getter
    public static class inquiry {
        private final String userKey;
        private final String userRegistrationNumber;

        private inquiry(String userKey, String userRegistrationNumber) {
            this.userKey = userKey;
            this.userRegistrationNumber = userRegistrationNumber;
        }
    }

    private UserResponse() {
    }

    public static UserResponse.enroll toEnroll(UserDto userDto) {
        return new UserResponse.enroll(userDto.getUserKey());
    }

    public static UserResponse.inquiry toInquiry(UserDto userDto) {
        return new UserResponse.inquiry(
                userDto.getUserKey(), userDto.getUserRegNum()
        );
    }
}
