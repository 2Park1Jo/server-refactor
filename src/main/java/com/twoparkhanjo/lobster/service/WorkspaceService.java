package com.twoparkhanjo.lobster.service;

import com.twoparkhanjo.lobster.domain.Workspace;
import com.twoparkhanjo.lobster.domain.WorkspaceRepository;
import com.twoparkhanjo.lobster.dto.WorkspaceSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public void save(WorkspaceSaveRequest workspaceSaveRequest) {
        workspaceRepository.save(workspaceSaveRequest.toEntity());
    }
}
