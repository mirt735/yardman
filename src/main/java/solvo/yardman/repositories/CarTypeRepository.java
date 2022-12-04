package solvo.yardman.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solvo.yardman.models.CarType;

import java.util.List;

@Repository
public interface CarTypeRepository extends PagingAndSortingRepository<CarType, Long> {

    List<CarType> findByCarId(Long carID);
}
