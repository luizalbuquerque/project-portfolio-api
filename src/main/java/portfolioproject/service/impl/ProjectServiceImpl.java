package portfolioproject.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolioproject.dto.ProjectDTO;
import portfolioproject.entity.ProjectEntity;
import portfolioproject.enun.ProjectStatus;
import portfolioproject.repository.ProjectRepository;
import portfolioproject.service.ProjectService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDTO> findAll() {
        List<ProjectEntity> projectEntities = projectRepository.findAll();
        return projectEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO findById(Long id) {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findById(id);
        return optionalProjectEntity.map(this::convertToDTO).orElse(null);
    }

    @Override
    public ProjectDTO create(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = convertToEntity(projectDTO);
        projectEntity = projectRepository.save(projectEntity);
        return convertToDTO(projectEntity);
    }

    @Override
    public ProjectDTO update(Long id, ProjectDTO projectDTO) {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findById(id);
        if (optionalProjectEntity.isPresent()) {
            ProjectEntity existingProjectEntity = optionalProjectEntity.get();
            BeanUtils.copyProperties(projectDTO, existingProjectEntity);
            existingProjectEntity.setId(id);
            existingProjectEntity = projectRepository.save(existingProjectEntity);
            return convertToDTO(existingProjectEntity);
        } else {
            return null; // Indicar que o projeto não foi encontrado
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<ProjectEntity> projectOptional = projectRepository.findById(id);

        if (projectOptional.isPresent()) {
            ProjectEntity projectEntity = projectOptional.get();

            if (canBeDeleted(projectEntity)) {
                projectRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean canBeDeleted(ProjectEntity projectEntity) {
        ProjectStatus currentStatus = projectEntity.getStatus();
        return currentStatus != ProjectStatus.INICIADO
                && currentStatus != ProjectStatus.EM_ANDAMENTO
                && currentStatus != ProjectStatus.ENCERRADO;
    }


    private ProjectDTO convertToDTO(ProjectEntity projectEntity) {
        ProjectDTO projectDTO = new ProjectDTO();
        BeanUtils.copyProperties(projectEntity, projectDTO);
        return projectDTO;
    }

    private ProjectEntity convertToEntity(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = new ProjectEntity();
        BeanUtils.copyProperties(projectDTO, projectEntity);
        return projectEntity;
    }

}
