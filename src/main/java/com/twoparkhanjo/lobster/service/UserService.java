package com.twoparkhanjo.lobster.service;

import com.twoparkhanjo.lobster.domain.user.UserRepository;
import com.twoparkhanjo.lobster.dto.UserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository memberRepository;

    public void save(UserSaveRequest userSaveRequest) {
        memberRepository.save(userSaveRequest.toEntity());
    }
}
