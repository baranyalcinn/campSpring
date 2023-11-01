package JavaDenemelerim.rentACar.core.utilities.mappers;

import JavaDenemelerim.rentACar.business.responses.GetAllModelsResponse;
import JavaDenemelerim.rentACar.concretes.Model;
import org.modelmapper.ModelMapper;

public interface ModelMappersService {
    ModelMapper forResponse();

    ModelMapper forRequest();

    Object map(Model model, Class<GetAllModelsResponse> getAllModelsResponseClass);
}
