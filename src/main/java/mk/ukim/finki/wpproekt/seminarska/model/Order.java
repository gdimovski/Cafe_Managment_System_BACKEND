package mk.ukim.finki.wpproekt.seminarska.model;

import lombok.Data;
import mk.ukim.finki.wpproekt.seminarska.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "desk_orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Desk table;

    private OrderStatus status;

    public Order(Desk table,OrderStatus status) {
        this.table = table;
        this.status = status;
    }

    public Order() {
    }
}
