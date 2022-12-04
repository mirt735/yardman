package solvo.yardman.services.crud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import solvo.yardman.models.Car;
import solvo.yardman.models.CarType;
import solvo.yardman.models.Driver;
import solvo.yardman.models.DriverPermit;
import solvo.yardman.models.dto.request.cartype.CarTypeRequestDTO;
import solvo.yardman.models.dto.request.driverPermit.DriverPermitRequestDTO;
import solvo.yardman.models.dto.response.cartype.CarTypeListDTO;
import solvo.yardman.models.dto.response.cartype.CarTypeResponseDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitListDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitResponseDTO;
import solvo.yardman.models.mappers.CarTypeMapper;
import solvo.yardman.repositories.CarRepository;
import solvo.yardman.repositories.CarTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarTypeService {

    private CarRepository carRepository;
    private CarTypeRepository carTypeRepository;
    private CarTypeMapper carTypeMapper;


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
        List<Car> cars = (List<Car>) carRepository.findAllById(requestBody.getCarIds());
        return carTypeRepository.findById(id)
                .map(carType ->
                {
                    carType.setType(requestBody.getType());
                    carType.setCapacity(requestBody.getCapacity());
                    carType.setHeight(requestBody.getHeight());
                    carType.setLength(requestBody.getLength());
                    carType.setWidth(requestBody.getWidth());
                    carType.setName(requestBody.getName());
                    carType.setCars(cars);

                    return carTypeMapper.toResponseDTO(carTypeRepository.save(carType));
                })
                .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        carTypeRepository.deleteById(id);
    }


}
