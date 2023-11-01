package rentACar.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
