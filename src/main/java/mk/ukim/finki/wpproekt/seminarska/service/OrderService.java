package mk.ukim.finki.wpproekt.seminarska.service;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.OrderItem;
import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.enums.OrderStatus;
import mk.ukim.finki.wpproekt.seminarska.web.dto.OrderItemInput;

import java.util.List;

public interface OrderService {

    Order findById(Long id);
    void create(Long deskId, List<OrderItemInput> items);
    Order update(Long id,Desk table, OrderStatus status);
    Order delete(Long id);
    List<Order> findAllActiveOrders();
    List<OrderItem> findAllOrderItemsByDeskId(Long deskId);
    List<Order> findAll();
    Integer getPriceOfAllOrderItems(Long id);

}
