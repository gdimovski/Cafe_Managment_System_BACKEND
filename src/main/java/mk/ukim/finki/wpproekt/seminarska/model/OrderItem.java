package mk.ukim.finki.wpproekt.seminarska.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    public Product product;
    @ManyToOne
    public Order order;

    public Integer quantity;

    public OrderItem(Product product,Order order, Integer quantity) {

        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    public OrderItem() {
    }
}
