package mk.ukim.finki.wpproekt.seminarska.repository;

import mk.ukim.finki.wpproekt.seminarska.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();
}
