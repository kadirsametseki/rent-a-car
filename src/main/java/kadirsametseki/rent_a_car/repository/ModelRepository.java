package kadirsametseki.rent_a_car.repository;

import kadirsametseki.rent_a_car.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
