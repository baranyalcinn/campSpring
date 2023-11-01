package JavaDenemelerim.rentACar.dataAcces.abstracts;

import JavaDenemelerim.rentACar.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
