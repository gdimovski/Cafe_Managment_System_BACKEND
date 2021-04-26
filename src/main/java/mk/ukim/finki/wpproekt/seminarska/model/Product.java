package mk.ukim.finki.wpproekt.seminarska.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.wpproekt.seminarska.model.enums.ProductType;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;


@Data
@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private Integer quantity;
    private Integer price;


    public Product(String code, String name, Integer quantity, Integer price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public Product() {

    }
}
