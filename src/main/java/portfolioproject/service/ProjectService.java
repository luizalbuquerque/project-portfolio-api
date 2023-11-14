package portfolioproject.service;

import org.springframework.stereotype.Service;
import portfolioproject.entity.ProjectEntity;
import portfolioproject.repository.ProjectRepository;
import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectEntity> findAll() {
        return projectRepository.findAll();
    }
}
