package JavaDenemelerim.rentACar.business.rules;

import JavaDenemelerim.rentACar.core.utilities.exceptions.BusinessException;
import JavaDenemelerim.rentACar.dataAcces.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists!");
        }
    }
}
