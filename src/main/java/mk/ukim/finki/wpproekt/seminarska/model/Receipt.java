package mk.ukim.finki.wpproekt.seminarska.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Order order;
    private LocalDateTime datum;


    public Receipt(Order order) {
        this.order = order;
        this.datum = LocalDateTime.now();
    }
    public Receipt() {

    }
}
