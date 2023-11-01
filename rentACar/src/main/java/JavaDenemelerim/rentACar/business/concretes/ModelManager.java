package JavaDenemelerim.rentACar.business.concretes;

import JavaDenemelerim.rentACar.business.abstracts.ModelService;
import JavaDenemelerim.rentACar.business.requests.CreateModelRequest;
import JavaDenemelerim.rentACar.business.responses.GetAllModelsResponse;
import JavaDenemelerim.rentACar.concretes.Model;
import JavaDenemelerim.rentACar.core.utilities.mappers.ModelMappersService;
import JavaDenemelerim.rentACar.dataAcces.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMappersService modelMappersService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMappersService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model =this.modelMappersService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
