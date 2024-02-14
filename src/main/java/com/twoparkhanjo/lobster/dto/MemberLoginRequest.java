package com.twoparkhanjo.lobster.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class MemberLoginRequest {
    @Schema(example = "member id")
    private String email;
    @Schema(example = "password")
    private String password;
    private String token;

    @Builder
    public MemberLoginRequest(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }
}
