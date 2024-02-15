package com.twoparkhanjo.lobster.service;

import com.twoparkhanjo.lobster.domain.member.Member;
import com.twoparkhanjo.lobster.domain.member.MemberRepository;
import com.twoparkhanjo.lobster.dto.MemberLoginRequest;
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

    public Member findMember(MemberLoginRequest memberLoginRequest) throws IllegalArgumentException {
        return memberRepository.findByEmailAndPassword(memberLoginRequest.getEmail(), memberLoginRequest.getPassword());
    }

    public boolean isDuplicatedId(String memberId) {
        return memberRepository.existsById(memberId);
    }
}
