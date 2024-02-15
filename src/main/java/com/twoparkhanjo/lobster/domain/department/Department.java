package com.twoparkhanjo.lobster.domain.department;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Builder
@NoArgsConstructor
@Table(name = "department")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", columnDefinition = "int")
    private String departmentId;

    @JoinColumn(name = "workspace_id", columnDefinition = "int", referencedColumnName = "workspace_id")
    @Column(name = "workspace_id")
    private int workspaceId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_goal")
    private String departmentGoal;

    @Column(name = "department_deadline")
    private String departmentDeadline;

    @Builder
    public Department(String departmentId, int workspaceId, String departmentName, String departmentGoal, String departmentDeadline) {
        this.departmentId = departmentId;
        this.workspaceId = workspaceId;
        this.departmentName = departmentName;
        this.departmentGoal = departmentGoal;
        this.departmentDeadline = departmentDeadline;
    }
}