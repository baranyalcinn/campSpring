package JavaDenemelerim.rentACar.dataAcces.abstracts;

import JavaDenemelerim.rentACar.concretes.Brand;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByName(String name);

}
