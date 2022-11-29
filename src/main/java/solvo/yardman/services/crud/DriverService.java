package solvo.yardman.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import solvo.yardman.models.Driver;
import solvo.yardman.models.dto.request.driver.DriverRequestDTO;
import solvo.yardman.models.dto.response.driver.DriverListDTO;
import solvo.yardman.models.dto.response.driver.DriverResponseDTO;
import solvo.yardman.models.mappers.DriverMapper;
import solvo.yardman.repositories.DriverRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverMapper driverMapper;

    public DriverListDTO list()
    {
        //TODO Page параметры передать извне
        List<DriverResponseDTO> response = driverRepository.findAll(PageRequest.of(0, 5))
                .getContent().stream().map(driverMapper::driverToDriverResponseDTO).collect(Collectors.toList());
        return new DriverListDTO(response, response.size());
    }

    public DriverResponseDTO add(DriverRequestDTO requestBody)
    {
        Driver driver = driverRepository.save(driverMapper.driverRequestDTOToDriver(requestBody));
        return driverMapper.driverToDriverResponseDTO(driver);
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
                    return driverMapper.driverToDriverResponseDTO(driverRepository.save(driver));
                })
            .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        driverRepository.deleteById(id);
    }

    public DriverResponseDTO findById(Long id)
    {
        return driverMapper.driverToDriverResponseDTO(driverRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
