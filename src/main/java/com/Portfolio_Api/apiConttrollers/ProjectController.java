package com.Portfolio_Api.apiConttrollers;

import com.Portfolio_Api.domain.models.Project;
import com.Portfolio_Api.domain.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    private ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjectController() {
        return projectService.getProject();
    }

    @PostMapping
    public void createProject(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam String technology,
                              @RequestParam MultipartFile img
                              ) throws IOException
                              {
        projectService.newProject(name,description,technology,img);
    }


    @PutMapping("/{id}")
    public void updateProject(@PathVariable Integer id, @RequestParam String name,
                              @RequestParam String description,@RequestParam String technology,
                              @RequestParam MultipartFile img) throws IOException {
        projectService.update(id, name, description,technology,img);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, Project project){
        projectService.deleteProject(id, project);
    }
}
