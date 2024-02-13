package com.twoparkhanjo.lobster.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByEmailAndPassword(String email, String password);
}
