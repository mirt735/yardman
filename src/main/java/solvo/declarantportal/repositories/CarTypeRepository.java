package solvo.declarantportal.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solvo.declarantportal.models.entities.CarType;

@Repository
public interface CarTypeRepository extends PagingAndSortingRepository<CarType, Long> {

}
