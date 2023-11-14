package portfolioproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolioproject.entity.ProjectEntity;

@Repository
    public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    }
