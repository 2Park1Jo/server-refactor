package com.twoparkhanjo.lobster.dto;

import com.twoparkhanjo.lobster.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class UserSaveRequest {
    @Schema(example = "user id")
    private String email;
    @Schema(example = "password")
    private String password;
    @Schema(example = "user name")
    private String userName;

    @Builder
    public UserSaveRequest(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .userName(userName)
                .build();
    }
}
