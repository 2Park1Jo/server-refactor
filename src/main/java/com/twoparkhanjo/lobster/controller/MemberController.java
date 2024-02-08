package com.twoparkhanjo.lobster.controller;

import com.twoparkhanjo.lobster.dto.MemberSaveRequest;
import com.twoparkhanjo.lobster.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public void register(@RequestBody MemberSaveRequest memberSaveRequest) {
        memberService.save(memberSaveRequest);
    }
}
