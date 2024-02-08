package com.twoparkhanjo.lobster.service;

import com.twoparkhanjo.lobster.domain.member.MemberRepository;
import com.twoparkhanjo.lobster.dto.MemberSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberSaveRequest memberSaveRequest) {
        memberRepository.save(memberSaveRequest.toEntity());
    }
}
