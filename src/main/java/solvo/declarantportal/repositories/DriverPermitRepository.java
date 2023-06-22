package solvo.declarantportal.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import solvo.declarantportal.models.entities.DriverPermit;

import java.util.List;

@Repository
public interface DriverPermitRepository extends PagingAndSortingRepository<DriverPermit, Long> {

    List<DriverPermit> findByDriverId(Long driverID);
}
