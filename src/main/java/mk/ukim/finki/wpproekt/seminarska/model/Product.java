package mk.ukim.finki.wpproekt.seminarska.model;


import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="product")
    List<OrderItem> orderItems;


    public Product(String code, String name, Integer quantity, Integer price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public Product() {

    }
}
