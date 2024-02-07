package com.twoparkhanjo.lobster.controller;

import com.twoparkhanjo.lobster.domain.WorkspaceRepository;
import com.twoparkhanjo.lobster.dto.WorkspaceSaveRequest;
import com.twoparkhanjo.lobster.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/workspaces")
@RestController()
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping("/create")
    public void save(@RequestBody WorkspaceSaveRequest workspaceSaveRequest) {
        workspaceService.save(workspaceSaveRequest);
    }
}
