package solvo.yardman.services.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import solvo.yardman.models.dto.request.aSample.ASampleRequestDTO;
import solvo.yardman.models.dto.response.aSample.ASampleListDTO;
import solvo.yardman.models.dto.response.aSample.ASampleResponseDTO;
import solvo.yardman.models.entities.ASample;
import solvo.yardman.models.mappers.ASampleMapper;
import solvo.yardman.repositories.ASampleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ASampleService 
{
    private final ASampleRepository aSampleRepository;

    private final ASampleMapper aSampleMapper;

    //TODO
    public ASampleListDTO list()
    {
        List<ASampleResponseDTO> response = aSampleRepository.findAll(PageRequest.of(0, 5))
                .getContent().stream().map(aSampleMapper::toResponseDTO).collect(Collectors.toList());
        return new ASampleListDTO(response, response.size());
    }

    public Page<ASampleResponseDTO> findPaginated(int pageNo, int pageSize)
    {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<ASample> entitiesPage = this.aSampleRepository.findAll(pageable);
        List<ASampleResponseDTO> dtoPage = entitiesPage.getContent().stream().map(aSampleMapper::toResponseDTO).collect(Collectors.toList());

        return new PageImpl<>(dtoPage, pageable, entitiesPage.getTotalElements());
    }

    public ASampleResponseDTO add(ASampleRequestDTO requestBody)
    {
        ASample aSample = aSampleRepository.save(aSampleMapper.toModel(requestBody));
        return aSampleMapper.toResponseDTO(aSample);
    }

    public ASampleResponseDTO update(Long id, ASampleRequestDTO requestBody)
    {
        return aSampleRepository.findById(id)
                .map(aSample ->
                {
                    aSample.setSampleString(requestBody.getSampleString());
                    aSample.setSampleInteger(requestBody.getSampleInteger());
                    aSample.setSampleDate(requestBody.getSampleDate());
                    aSample.setSampleTime(requestBody.getSampleTime());
                    aSample.setSampleBoolean(requestBody.isSampleBoolean());
                    aSample.setSampleEmail(requestBody.getSampleEmail());
                    aSample.setSampleIntegerSelectValue(requestBody.getSampleIntegerSelectValue());
                    aSample.setSampleStringSelectValue(requestBody.getSampleStringSelectValue());
                    return aSampleMapper.toResponseDTO(aSampleRepository.save(aSample));
                })
                .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        aSampleRepository.deleteById(id);
    }

    public ASampleResponseDTO findById(Long id)
    {
        ASample aSample = aSampleRepository.findById(id).orElseThrow(NullPointerException::new);
        return aSampleMapper.toResponseDTO(aSample);
    }
}
