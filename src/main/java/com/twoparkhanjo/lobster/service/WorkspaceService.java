package com.twoparkhanjo.lobster.service;

import com.twoparkhanjo.lobster.domain.Workspace;
import com.twoparkhanjo.lobster.domain.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public void save(Workspace workspace) {
        workspaceRepository.save(workspace);
    }
}
