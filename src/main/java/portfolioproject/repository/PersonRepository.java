package portfolioproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolioproject.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}

