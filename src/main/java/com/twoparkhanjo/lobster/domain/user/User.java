package com.twoparkhanjo.lobster.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Builder
@NoArgsConstructor
@Table(name = "user")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Column(name = "user_id")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name")
    private String userName;
    @JoinColumn(name = "last_accessed_workspace_id", columnDefinition = "int", referencedColumnName = "workspace_id")
    private int lastAccessedWorkspaceId;

    @Builder
    public User(String email, String password, String userName, int lastAccessedWorkspaceId) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.lastAccessedWorkspaceId = lastAccessedWorkspaceId;
    }
}
