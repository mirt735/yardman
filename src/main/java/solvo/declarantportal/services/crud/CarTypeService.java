package solvo.declarantportal.services.crud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import solvo.declarantportal.models.dto.request.cartype.CarTypeRequestDTO;
import solvo.declarantportal.models.dto.response.cartype.CarTypeListDTO;
import solvo.declarantportal.models.dto.response.cartype.CarTypeResponseDTO;
import solvo.declarantportal.models.entities.CarType;
import solvo.declarantportal.models.mappers.CarTypeMapper;
import solvo.declarantportal.repositories.CarTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarTypeService {

    private final CarTypeRepository carTypeRepository;
    private final CarTypeMapper carTypeMapper;


    public CarTypeListDTO list()
    {
        List<CarTypeResponseDTO> response = carTypeRepository.findAll(PageRequest.of(0, 5))
                .getContent().stream().map(carTypeMapper::toResponseDTO).collect(Collectors.toList());
        return new CarTypeListDTO(response, response.size());
    }

    public CarTypeResponseDTO findById(Long id)
    {
        return carTypeMapper.toResponseDTO(carTypeRepository.findById(id)
                .orElseThrow(NullPointerException::new));
    }

    public CarTypeResponseDTO add(CarTypeRequestDTO requestBody)
    {
        CarType carType = carTypeMapper.toModel(requestBody);
        carTypeRepository.save(carType);
        return carTypeMapper.toResponseDTO(carType);
    }

    public CarTypeResponseDTO update(Long id, CarTypeRequestDTO requestBody)
    {
        return carTypeRepository.findById(id)
                .map(carType ->
                {
                    carType.setKind(requestBody.getKind());
                    carType.setLoadCapacity(requestBody.getLoadCapacity());
                    carType.setHeight(requestBody.getHeight());
                    carType.setLength(requestBody.getLength());
                    carType.setWidth(requestBody.getWidth());
                    carType.setName(requestBody.getName());

                    return carTypeMapper.toResponseDTO(carTypeRepository.save(carType));
                })
                .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        carTypeRepository.deleteById(id);
    }


}
