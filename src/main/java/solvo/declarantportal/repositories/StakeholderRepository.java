package solvo.declarantportal.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solvo.declarantportal.models.entities.Stakeholder;

@Repository
public interface StakeholderRepository extends PagingAndSortingRepository<Stakeholder, Long> {
}
