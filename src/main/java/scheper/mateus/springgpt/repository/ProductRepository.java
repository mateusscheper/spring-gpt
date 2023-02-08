package scheper.mateus.springgpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scheper.mateus.springgpt.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

