package com.twoparkhanjo.lobster.dto;

import com.twoparkhanjo.lobster.domain.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class MemberSaveRequest {
    @Schema(example = "member id")
    private String email;
    @Schema(example = "password")
    private String password;
    @Schema(example = "member name")
    private String memberName;

    @Builder
    public MemberSaveRequest(String email, String password, String memberName) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .memberName(memberName)
                .build();
    }
}
