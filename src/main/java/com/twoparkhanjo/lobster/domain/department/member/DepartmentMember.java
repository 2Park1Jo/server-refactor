package com.twoparkhanjo.lobster.domain.department.member;

import com.twoparkhanjo.lobster.domain.primarykey.DepartmentMemberPK;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@IdClass(DepartmentMemberPK.class)
@Getter
@Builder
@NoArgsConstructor
@Table(name = "department_member")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class DepartmentMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "department_id", columnDefinition = "int", referencedColumnName = "department_id")
    private int departmentId;

    @Id
    @JoinColumn(name = "member_id", columnDefinition = "int", referencedColumnName = "member_id")
    private String email;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "department_role")
    private String departmentRole;

    @Column(name = "department_grade")
    private String departmentGrade;

    @Builder
    public DepartmentMember(int departmentId, String email, String memberName, String departmentRole, String departmentGrade) {
        this.departmentId = departmentId;
        this.email = email;
        this.memberName = memberName;
        this.departmentRole = departmentRole;
        this.departmentGrade = departmentGrade;
    }
}
