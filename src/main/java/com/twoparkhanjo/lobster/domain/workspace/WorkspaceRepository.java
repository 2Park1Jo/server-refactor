package com.twoparkhanjo.lobster.domain.workspace;

import com.twoparkhanjo.lobster.domain.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
}
