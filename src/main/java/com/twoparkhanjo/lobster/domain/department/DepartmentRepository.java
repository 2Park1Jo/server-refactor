package com.twoparkhanjo.lobster.domain.department;

import com.twoparkhanjo.lobster.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
