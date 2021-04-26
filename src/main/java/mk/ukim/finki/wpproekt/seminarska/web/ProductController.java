package mk.ukim.finki.wpproekt.seminarska.web;

import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.enums.ProductType;
import mk.ukim.finki.wpproekt.seminarska.model.enums.SimpleProductType;
import mk.ukim.finki.wpproekt.seminarska.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.productService.findAll();
    }

    @PostMapping("/products/create")
    public Product createNewProduct(@RequestBody Product product){
        return this.productService.create(product);
    }

    @DeleteMapping("/products/delete/{id}")
    public Product deleteProduct(@PathVariable Long id){
        return this.productService.delete(id);
    }

    @PostMapping("/products/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return this.productService.update(id, product);
    }

}
