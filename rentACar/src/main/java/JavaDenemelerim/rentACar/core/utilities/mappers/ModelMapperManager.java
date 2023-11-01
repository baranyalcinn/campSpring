package JavaDenemelerim.rentACar.core.utilities.mappers;

import JavaDenemelerim.rentACar.business.responses.GetAllModelsResponse;
import JavaDenemelerim.rentACar.concretes.Model;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMappersService {
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }

    @Override
    public Object map(Model model, Class<GetAllModelsResponse> getAllModelsResponseClass) {
        return null;
    }
}
