package solvo.declarantportal.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solvo.declarantportal.models.entities.Driver;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<Driver, Long> {
}
