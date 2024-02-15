package com.twoparkhanjo.lobster.domain.workspace;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@Table(name = "workspace")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workspace_id", columnDefinition = "int")
    private int workspaceId;

    @Column(name = "workspace_name")
    private String workspaceName;

    @Column(name = "goal")
    private String goal;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "deadline", columnDefinition = "date")
    private LocalDate deadline;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "created_at", columnDefinition = "date")
    private LocalDate createdAt;

    @Builder
    public Workspace(int workspaceId, String workspaceName, String goal, LocalDate deadline, LocalDate createdAt) {
        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
        this.goal = goal;
        this.deadline = deadline;
        this.createdAt = createdAt;
    }
}
