package com.twoparkhanjo.lobster.controller;

import com.twoparkhanjo.lobster.domain.member.Member;
import com.twoparkhanjo.lobster.dto.MemberLoginRequest;
import com.twoparkhanjo.lobster.dto.MemberSaveRequest;
import com.twoparkhanjo.lobster.security.JwtTokenProvider;
import com.twoparkhanjo.lobster.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "회원")
@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public void register(@RequestBody MemberSaveRequest memberSaveRequest) {
        memberService.save(memberSaveRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest memberLoginRequest) {
        Member member = memberService.findMember(memberLoginRequest);

        if (member != null) {
            MemberLoginRequest memberLoginResponse = MemberLoginRequest.builder()
                    .email(member.getEmail())
                    .token(jwtTokenProvider.createToken(member))
                    .build();

            return ResponseEntity.ok().body(memberLoginResponse);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
