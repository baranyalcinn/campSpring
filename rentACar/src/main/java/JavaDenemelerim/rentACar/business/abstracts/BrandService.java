package JavaDenemelerim.rentACar.business.abstracts;


import JavaDenemelerim.rentACar.business.requests.CreateBrandRequest;
import JavaDenemelerim.rentACar.business.requests.UpdateBrandRequest;
import JavaDenemelerim.rentACar.business.responses.GetAllBrandsResponse;
import JavaDenemelerim.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
