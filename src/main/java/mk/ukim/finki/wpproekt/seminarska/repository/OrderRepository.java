package mk.ukim.finki.wpproekt.seminarska.repository;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByTable(Desk deskId);
}
