package mk.ukim.finki.wpproekt.seminarska.repository;

import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findOrderItemByOrder(Order id);
}
