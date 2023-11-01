package JavaDenemelerim.rentACar.business.concretes;

import JavaDenemelerim.rentACar.business.abstracts.BrandService;
import JavaDenemelerim.rentACar.business.requests.CreateBrandRequest;
import JavaDenemelerim.rentACar.business.requests.UpdateBrandRequest;
import JavaDenemelerim.rentACar.business.responses.GetAllBrandsResponse;
import JavaDenemelerim.rentACar.business.responses.GetByIdBrandResponse;
import JavaDenemelerim.rentACar.business.rules.BrandBusinessRules;
import JavaDenemelerim.rentACar.concretes.Brand;
import JavaDenemelerim.rentACar.core.utilities.mappers.ModelMappersService;
import JavaDenemelerim.rentACar.dataAcces.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMappersService modelMappersService;
    public BrandBusinessRules brandBusinessRules;

    @Override

    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMappersService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
       Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMappersService
                .forResponse().map(brand, GetByIdBrandResponse.class);
       return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMappersService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMappersService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
