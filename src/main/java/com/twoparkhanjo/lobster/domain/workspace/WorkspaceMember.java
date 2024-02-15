package com.twoparkhanjo.lobster.domain.workspace;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
public class WorkspaceMember {
    @Id
    @Column(name = "member_id")
    private String memberId;
    @ManyToOne(targetEntity = Workspace.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id", columnDefinition = "int", referencedColumnName = "workspace_id")
    private int workspaceId;
    @Column(name = "member_name")
    private String memberName;

    @Builder
    public WorkspaceMember(String memberId, int workspaceId, String memberName) {
        this.memberId = memberId;
        this.workspaceId = workspaceId;
        this.memberName = memberName;
    }
}
