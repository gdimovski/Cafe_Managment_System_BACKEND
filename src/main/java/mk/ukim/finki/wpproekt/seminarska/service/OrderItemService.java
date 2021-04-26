package mk.ukim.finki.wpproekt.seminarska.service;

import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.OrderItem;
import mk.ukim.finki.wpproekt.seminarska.model.Product;

import java.util.List;

public interface OrderItemService {

    OrderItem create(Product product, Order order, Integer quantity);
    OrderItem update(Long id, Product product, Order order, Integer quantity);
    OrderItem delete(Long id);
    OrderItem findById(Long id);
    List<OrderItem> findAll();
    List<OrderItem> findByOrder(Long orderId);
    List<OrderItem> findByDesk(Long deskId);
}
