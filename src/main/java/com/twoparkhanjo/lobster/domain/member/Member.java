package com.twoparkhanjo.lobster.domain.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Builder
@NoArgsConstructor
@Table(name = "member")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id
    @Column(name = "member_id")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "member_name")
    private String memberName;

    @JoinColumn(name = "last_accessed_workspace_id", columnDefinition = "int", referencedColumnName = "workspace_id")
    private int lastAccessedWorkspaceId;

    @Builder
    public Member(String email, String password, String memberName, int lastAccessedWorkspaceId) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.lastAccessedWorkspaceId = lastAccessedWorkspaceId;
    }
}
