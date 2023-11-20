package portfolioproject.service;

import portfolioproject.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> findAll();
    ProjectDTO findById(Long id);
    ProjectDTO create(ProjectDTO projectDTO);
    ProjectDTO update(Long id, ProjectDTO projectDTO);
    boolean delete(Long id);

}
