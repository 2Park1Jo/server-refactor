package com.twoparkhanjo.lobster.domain.workspace;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
public class WorkspaceUser {
    @Id
    @Column(name = "user_id")
    private String userId;
    @ManyToOne(targetEntity = Workspace.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id", columnDefinition = "int", referencedColumnName = "workspace_id")
    private int workspaceId;
    @Column(name = "user_name")
    private String userName;

    @Builder
    public WorkspaceUser(String userId, int workspaceId, String userName) {
        this.userId = userId;
        this.workspaceId = workspaceId;
        this.userName = userName;
    }
}
