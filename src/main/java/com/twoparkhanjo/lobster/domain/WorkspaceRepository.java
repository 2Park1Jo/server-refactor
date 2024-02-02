package com.twoparkhanjo.lobster.domain;

import com.twoparkhanjo.lobster.domain.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
}
