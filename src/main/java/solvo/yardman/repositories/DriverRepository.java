package solvo.yardman.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solvo.yardman.models.entities.Driver;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<Driver, Long> {
}
