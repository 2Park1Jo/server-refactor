package com.twoparkhanjo.lobster.dto;

import com.twoparkhanjo.lobster.domain.Workspace;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
