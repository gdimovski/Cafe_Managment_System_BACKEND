package mk.ukim.finki.wpproekt.seminarska.service;

import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.enums.ProductType;
import mk.ukim.finki.wpproekt.seminarska.model.enums.SimpleProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    Product delete(Long id);
}
