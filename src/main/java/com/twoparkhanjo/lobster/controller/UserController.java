package com.twoparkhanjo.lobster.controller;

import com.twoparkhanjo.lobster.domain.user.User;
import com.twoparkhanjo.lobster.dto.UserLoginRequest;
import com.twoparkhanjo.lobster.dto.UserSaveRequest;
import com.twoparkhanjo.lobster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody UserSaveRequest userSaveRequest) {
        userService.save(userSaveRequest);
    }

    @PostMapping("/login")
    public void login(@RequestBody UserLoginRequest userLoginRequest) {
        userService.findUser(userLoginRequest);
    }
}
