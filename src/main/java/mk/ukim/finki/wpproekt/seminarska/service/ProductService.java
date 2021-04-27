package mk.ukim.finki.wpproekt.seminarska.service;

import mk.ukim.finki.wpproekt.seminarska.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    Product delete(Long id);
}
