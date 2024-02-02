package com.twoparkhanjo.lobster.dto;

import com.twoparkhanjo.lobster.domain.Workspace;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
public class WorkspaceSaveRequest {
    private String workspaceName;
    private String goal;
    private String deadline;

    @Builder
    public WorkspaceSaveRequest(String workspaceName, String goal, String deadline) {
        this.workspaceName = workspaceName;
        this.goal = goal;
        this.deadline = deadline;
    }

    public Workspace toEntity() {
        return Workspace.builder()
                .workspaceName(workspaceName)
                .goal(goal)
                .deadline(LocalDate.parse(deadline))
                .build();
    }
}
