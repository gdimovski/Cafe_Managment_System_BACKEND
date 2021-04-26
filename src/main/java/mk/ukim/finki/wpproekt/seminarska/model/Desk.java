package mk.ukim.finki.wpproekt.seminarska.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import mk.ukim.finki.wpproekt.seminarska.model.enums.TableStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tableNumber;
    private TableStatus tableStatus;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="table")
    List<Order> orders;

    public Desk() {
    }

    public Desk(Long tableNumber, TableStatus tableStatus) {
        this.tableNumber = tableNumber;
        this.tableStatus = tableStatus;
    }

    public Long getId() {
        return id;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }
}
