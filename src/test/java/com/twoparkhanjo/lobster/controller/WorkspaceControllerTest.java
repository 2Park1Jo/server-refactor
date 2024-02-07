package com.twoparkhanjo.lobster.controller;

import com.twoparkhanjo.lobster.dto.WorkspaceSaveRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=update"
})
class WorkspaceControllerTest {
    @LocalServerPort
    private int port;
    private final String URL = "http://localhost:";
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void save() {
        WorkspaceSaveRequest workspace = WorkspaceSaveRequest.builder()
                .workspaceName("붕어빵 워크스페이스")
                .goal("세상 모든 붕어빵을 위하여")
                .deadline("2024-7-6")
                .build();

        String postUrl = URL + port + "/workspaces/create";

        ResponseEntity<HttpStatusCode> responseEntity = testRestTemplate.postForEntity(postUrl, workspace, HttpStatusCode.class);

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}