package com.twoparkhanjo.lobster.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "workspace")
@Builder
@NoArgsConstructor
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workspace_id", columnDefinition = "int")
    private int workspaceId;
    @Column(name = "workspace_name")
    private String workspaceName;
    @Column(name = "goal")
    private String goal;
    @Column(name = "deadline")
    private String deadline;
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "created_at", columnDefinition = "date")
    private Date createdAt;

    @Builder
    public Workspace(Integer workspaceId, String workspaceName, String goal, String deadline, Date createdAt) {
        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
        this.goal = goal;
        this.deadline = deadline;
        this.createdAt = createdAt;
    }
}
