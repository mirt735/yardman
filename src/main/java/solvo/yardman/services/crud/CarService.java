package solvo.yardman.services.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import solvo.yardman.models.dto.request.car.CarRequestDTO;
import solvo.yardman.models.dto.response.car.CarListDTO;
import solvo.yardman.models.dto.response.car.CarResponseDTO;
import solvo.yardman.models.dto.response.cartype.CarTypeResponseDTO;
import solvo.yardman.models.entities.Car;
import solvo.yardman.models.entities.CarType;
import solvo.yardman.models.mappers.CarMapper;
import solvo.yardman.models.mappers.CarTypeMapper;
import solvo.yardman.repositories.CarRepository;
import solvo.yardman.repositories.CarTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarTypeRepository carTypeRepository;
    private final CarMapper carMapper;
    private final CarTypeMapper carTypeMapper;

    public CarListDTO list()
    {
        List<CarResponseDTO> response = carRepository.findAll(PageRequest.of(0, 5))
                .getContent().stream().map(carMapper::toResponseDTO).collect(Collectors.toList());
        return new CarListDTO(response, response.size());
    }

    public CarResponseDTO add(CarRequestDTO requestBody)
    {
        CarType carType = carTypeRepository.findById(requestBody.getCarTypeId())
                .orElseThrow(NullPointerException::new);
        Car car = carMapper.toModel(requestBody);
        car.setCarType(carType);
        Car carSaved = carRepository.save(car);
        return carMapper.toResponseDTO(carSaved);
    }

    public CarResponseDTO update(Long id, CarRequestDTO requestBody)
    {
        CarType carType = carTypeRepository.findById(requestBody.getCarTypeId())
                .orElseThrow(NullPointerException::new);
        return carRepository.findById(id)
            .map(car ->
                {
                    car.setRegNumber(requestBody.getRegNumber());
                    car.setCarType(carType);
                    car.setCarrierId(requestBody.getCarrierId());
                    return carMapper.toResponseDTO(carRepository.save(car));
                })
            .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        carRepository.deleteById(id);
    }

    public CarResponseDTO findById(Long id)
    {
        Car car = carRepository.findById(id).orElseThrow(NullPointerException::new);
        CarTypeResponseDTO carTypeResponseDTO = carTypeMapper.toResponseDTO(car.getCarType());
        CarResponseDTO carResponseDTO = carMapper.toResponseDTO(car);
        carResponseDTO.setCarType(carTypeResponseDTO);
        return carResponseDTO;
    }

    public CarListDTO getCarListByCarType(Long id) {
        List<CarResponseDTO> response = carRepository.findByCarType_Id(id)
                .stream().map(carMapper::toResponseDTO).collect(Collectors.toList());
        return new CarListDTO(response, response.size());
    }
}
