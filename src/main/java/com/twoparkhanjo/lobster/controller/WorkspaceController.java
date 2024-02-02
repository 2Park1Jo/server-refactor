package com.twoparkhanjo.lobster.controller;

import com.twoparkhanjo.lobster.domain.Workspace;
import com.twoparkhanjo.lobster.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/workspace")
@RequiredArgsConstructor
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping("/posts")
    public void save(@RequestBody Workspace workspace) {
        workspaceService.save(workspace);
    }
}
