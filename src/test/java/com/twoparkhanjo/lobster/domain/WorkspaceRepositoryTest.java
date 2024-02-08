package com.twoparkhanjo.lobster.domain;

import com.twoparkhanjo.lobster.domain.workspace.Workspace;
import com.twoparkhanjo.lobster.domain.workspace.WorkspaceRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=update" // 테이블 자동 생성 설정
})
class WorkspaceRepositoryTest {
    @Autowired
    private WorkspaceRepository workspaceRepository;

    @After("")
    private void cleanUp() {
        workspaceRepository.deleteAll();
    }

    @DisplayName("워크스페이스 생성 및 저장 테스트")
    @Test
    void save() {
        workspaceRepository.save(Workspace.builder()
                .workspaceName("붕어빵 워크스페이스")
                .goal("세상 모든 붕어빵을 위하여")
                .deadline(LocalDate.parse("2024-03-04"))
                .build());

        List<Workspace> workspaceList = workspaceRepository.findAll();

        Workspace workspace = workspaceList.get(0);

        Assertions.assertEquals(workspace.getWorkspaceName(), "붕어빵 워크스페이스");
        Assertions.assertEquals(workspace.getGoal(), "세상 모든 붕어빵을 위하여");
    }
}