package JavaDenemelerim.rentACar.business.abstracts;

import JavaDenemelerim.rentACar.business.requests.CreateModelRequest;
import JavaDenemelerim.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
