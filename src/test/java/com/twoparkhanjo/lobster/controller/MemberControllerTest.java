package com.twoparkhanjo.lobster.controller;

import com.twoparkhanjo.lobster.dto.MemberLoginRequest;
import com.twoparkhanjo.lobster.dto.MemberSaveRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=update"
})
class MemberControllerTest {
    @LocalServerPort
    private int port;
    private final String URL = "http://localhost:";
    @Autowired
    private TestRestTemplate testRestTemplate;

    @DisplayName("회원가입 테스트")
    @Test
    void register() {
        MemberSaveRequest memberSaveRequest = MemberSaveRequest.builder()
                .memberName("박지민")
                .email("abc@naver.com")
                .password("12345")
                .build();

        String postUrl = URL + port + "/members/register";

        ResponseEntity<HttpStatusCode> responseEntity = testRestTemplate.postForEntity(postUrl, memberSaveRequest, HttpStatusCode.class);

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void login() {
        MemberSaveRequest memberSaveRequest = MemberSaveRequest.builder()
                .memberName("박지민")
                .email("abc@naver.com")
                .password("12345")
                .build();

        String postUrl = URL + port + "/members/register";
        testRestTemplate.postForEntity(postUrl, memberSaveRequest, HttpStatusCode.class);

        MemberLoginRequest memberLoginRequest = MemberLoginRequest.builder()
                .email("abc@naver.com")
                .password("12345")
                .build();

        postUrl = URL + port + "/members/login";
        ResponseEntity<HttpStatusCode> responseEntity = testRestTemplate.postForEntity(postUrl, memberLoginRequest, HttpStatusCode.class);

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}