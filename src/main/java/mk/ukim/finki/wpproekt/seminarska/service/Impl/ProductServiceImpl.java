package mk.ukim.finki.wpproekt.seminarska.service.Impl;

import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.repository.ProductRepository;
import mk.ukim.finki.wpproekt.seminarska.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }




    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product updateProduct = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        updateProduct.setCode(product.getCode());
        updateProduct.setName(product.getName());
        updateProduct.setQuantity(product.getQuantity());
        updateProduct.setPrice(product.getPrice());

        return this.productRepository.save(updateProduct);
    }

    @Override
    public Product delete(Long id) {
        Product p = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.productRepository.deleteById(id);
        return p;
    }


}
