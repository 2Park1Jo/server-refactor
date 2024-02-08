package com.twoparkhanjo.lobster.dto;

import com.twoparkhanjo.lobster.domain.workspace.Workspace;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Builder
@NoArgsConstructor
public class WorkspaceSaveRequest {
    @Schema(example = "워크스페이스명")
    private String workspaceName;
    @Schema(example = "목표")
    private String goal;
    @Schema(example = "2024-01-01")
    private String deadline;

    @Builder
    public WorkspaceSaveRequest(String workspaceName, String goal, String deadline) {
        this.workspaceName = workspaceName;
        this.goal = goal;
        this.deadline = deadline;
    }

    private LocalDate formatDate(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-M-d");
        return LocalDate.parse(date, format);
    }

    public Workspace toEntity() {
        return Workspace.builder()
                .workspaceName(workspaceName)
                .goal(goal)
                .deadline(formatDate(deadline))
                .build();
    }
}
