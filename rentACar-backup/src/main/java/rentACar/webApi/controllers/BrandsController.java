package rentACar.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rentACar.business.abstracts.BrandService;
import rentACar.entities.concretes.Brand;

import java.util.List;

@RestController
@RequestMapping(value = "/api/brands", method = RequestMethod.GET)

public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(value = "/getall")
    public List<Brand> getAll() {
        return brandService.getAll();
    }
}
