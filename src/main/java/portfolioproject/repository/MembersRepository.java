package portfolioproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolioproject.entity.MembersEntity;

@Repository
public interface MembersRepository extends JpaRepository<MembersEntity, Long> {
}
