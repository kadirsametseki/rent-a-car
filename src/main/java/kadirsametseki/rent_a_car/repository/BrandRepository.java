package kadirsametseki.rent_a_car.repository;

import kadirsametseki.rent_a_car.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
