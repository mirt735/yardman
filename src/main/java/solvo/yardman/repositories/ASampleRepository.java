package solvo.yardman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solvo.yardman.models.entities.ASample;

@Repository
public interface ASampleRepository extends JpaRepository<ASample, Long> {
}
