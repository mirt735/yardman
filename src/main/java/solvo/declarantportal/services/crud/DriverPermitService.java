package solvo.declarantportal.services.crud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import solvo.declarantportal.models.dto.request.driverPermit.DriverPermitRequestDTO;
import solvo.declarantportal.models.dto.response.driverPermit.DriverPermitListDTO;
import solvo.declarantportal.models.dto.response.driverPermit.DriverPermitResponseDTO;
import solvo.declarantportal.models.entities.Driver;
import solvo.declarantportal.models.entities.DriverPermit;
import solvo.declarantportal.models.mappers.DriverPermitMapper;
import solvo.declarantportal.repositories.DriverPermitRepository;
import solvo.declarantportal.repositories.DriverRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverPermitService {

    private final DriverPermitRepository driverPermitRepository;

    private final DriverRepository driverRepository;

    private final DriverPermitMapper driverPermitMapper;

    public DriverPermitListDTO list()
    {
        //TODO Page параметры передать извне
        List<DriverPermitResponseDTO> response = driverPermitRepository.findAll(PageRequest.of(0, 5))
                .getContent().stream().map(driverPermitMapper::toResponseDTO).collect(Collectors.toList());
        return new DriverPermitListDTO(response, response.size());
    }

    public DriverPermitListDTO list(Long driverID)
    {
        //TODO Page параметры передать извне
        List<DriverPermitResponseDTO> response = driverPermitRepository.findByDriverId(driverID).stream().map(driverPermitMapper::toResponseDTO).collect(Collectors.toList());
        return new DriverPermitListDTO(response, response.size());
    }

    public DriverPermitResponseDTO add(Long driverId, DriverPermitRequestDTO requestBody)
    {
        Driver driver = driverRepository.findById(driverId).orElseThrow(NullPointerException::new);
        DriverPermit driverPermit = driverPermitMapper.toModel(requestBody);
        driverPermit.setDriver(driver);
        driverPermitRepository.save(driverPermit);
        return driverPermitMapper.toResponseDTO(driverPermit);
    }

    public DriverPermitResponseDTO update(Long driverID, Long id, DriverPermitRequestDTO requestBody)
    {
        return driverPermitRepository.findById(id)
                .map(driverPermit ->
                {
                    driverPermit.setPermitID(requestBody.getPermitID());
                    //TODO нормальное исключение
                    Driver driver = driverRepository.findById(driverID).orElseThrow(NullPointerException::new);
                    driverPermit.setDriver(driver);
                    return driverPermitMapper.toResponseDTO(driverPermitRepository.save(driverPermit));
                })
                .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        driverPermitRepository.deleteById(id);
    }

    public DriverPermitResponseDTO findById(Long id)
    {
        return driverPermitMapper.toResponseDTO(driverPermitRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
