package com.twoparkhanjo.lobster.domain.primarykey;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class DepartmentMemberPK implements Serializable {

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "member_id")
    private String email;
}