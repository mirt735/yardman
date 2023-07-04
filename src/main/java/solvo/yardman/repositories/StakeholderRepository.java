package solvo.yardman.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solvo.yardman.models.entities.Stakeholder;

@Repository
public interface StakeholderRepository extends PagingAndSortingRepository<Stakeholder, Long> {
}
