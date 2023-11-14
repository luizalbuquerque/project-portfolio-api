package portfolioproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolioproject.entity.ProjectEntity;
import portfolioproject.service.ProjectService;

import java.util.List;

    @RestController
    @RequestMapping("/projects")
    public class ProjectController {

       private ProjectService projectService;

        @GetMapping
        public ResponseEntity<List<ProjectEntity>> getAllProjetos() {
            return ResponseEntity.ok(projectService.findAll());
        }
}
