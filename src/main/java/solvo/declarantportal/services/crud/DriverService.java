package solvo.declarantportal.services.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import solvo.declarantportal.models.dto.request.driver.DriverRequestDTO;
import solvo.declarantportal.models.dto.response.driver.DriverListDTO;
import solvo.declarantportal.models.dto.response.driver.DriverResponseDTO;
import solvo.declarantportal.models.dto.response.driverPermit.DriverPermitListDTO;
import solvo.declarantportal.models.dto.response.driverPermit.DriverPermitResponseDTO;
import solvo.declarantportal.models.entities.Driver;
import solvo.declarantportal.models.mappers.DriverMapper;
import solvo.declarantportal.models.mappers.DriverPermitMapper;
import solvo.declarantportal.repositories.DriverRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    private final DriverPermitMapper driverPermitMapper;

    public DriverListDTO list()
    {
        //TODO Page параметры передать извне
        List<DriverResponseDTO> response = driverRepository.findAll(PageRequest.of(0, 5))
                .getContent().stream().map(driverMapper::toResponseDTO).collect(Collectors.toList());
        return new DriverListDTO(response, response.size());
    }

    public DriverResponseDTO add(DriverRequestDTO requestBody)
    {
        Driver driver = driverRepository.save(driverMapper.toModel(requestBody));
        return driverMapper.toResponseDTO(driver);
    }

    public DriverResponseDTO update(Long id, DriverRequestDTO requestBody)
    {
        return driverRepository.findById(id)
            .map(driver ->
                {
                    driver.setFullName(requestBody.getFullName());
                    driver.setPhone(requestBody.getPhone());
                    driver.setPassport(requestBody.getPassport());
                    driver.setPassportIssuedBy(requestBody.getPassportIssuedBy());
                    return driverMapper.toResponseDTO(driverRepository.save(driver));
                })
            .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        driverRepository.deleteById(id);
    }

    public DriverResponseDTO findById(Long id)
    {
        Driver driver = driverRepository.findById(id).orElseThrow(NullPointerException::new);
        List<DriverPermitResponseDTO> permitResponseDTOList = driver.getPermits().stream().map(driverPermitMapper::toResponseDTO).collect(Collectors.toList());
        DriverResponseDTO driverResponseDTO = driverMapper.toResponseDTO(driver);
        driverResponseDTO.setPermits(new DriverPermitListDTO(permitResponseDTOList, permitResponseDTOList.size()));
        return driverResponseDTO;
    }
}
