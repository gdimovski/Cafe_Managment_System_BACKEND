package mk.ukim.finki.wpproekt.seminarska.service.Impl;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.OrderItem;
import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.enums.OrderStatus;
import mk.ukim.finki.wpproekt.seminarska.model.enums.TableStatus;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.DeskNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.repository.DeskRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.OrderItemRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.OrderRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.ProductRepository;
import mk.ukim.finki.wpproekt.seminarska.service.OrderService;
import mk.ukim.finki.wpproekt.seminarska.web.dto.OrderItemInput;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final DeskRepository deskRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, DeskRepository deskRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.deskRepository = deskRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Order findById(Long id) {
        return this.orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public void create(Long deskId, List<OrderItemInput> items) {
        Desk desk = deskRepository.findById(deskId).orElseThrow(DeskNotFoundException::new);
        Order order = this.orderRepository.save(new Order(desk, OrderStatus.ACTIVE)) ;

        items.forEach(item -> {
            Product product = productRepository.findById(item.getProductId()).orElseThrow(ProductNotFoundException::new);
            this.orderItemRepository.save(new OrderItem(product, order, item.getQuantity()));

            Integer newQuantity = product.getQuantity() - item.getQuantity();
            product.setQuantity(newQuantity);
            productRepository.save(product);

        });

        desk.setTableStatus(TableStatus.TAKEN);
        deskRepository.save(desk);

    }

    @Override
    public Order update(Long id,Desk table, OrderStatus status) {
        Order order = this.orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        order.setTable(table);
        order.setStatus(status);
        return this.orderRepository.save(order);


    }

    @Override
    public Order delete(Long id) {
        Order order = this.findById(id);
        this.orderRepository.delete(order);
        return order;
    }

    @Override
    public List<Order> findAllActiveOrders() {
        return this.orderRepository.findAll()
                .stream()
                .filter(order -> order.getStatus().equals(OrderStatus.ACTIVE))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderItem> findAllOrderItemsByDeskId(Long deskId) {
        Order order = orderRepository.findOrderByTableAndStatus(deskRepository.findById(deskId).orElseThrow(DeskNotFoundException::new), OrderStatus.ACTIVE);
        return orderItemRepository.findOrderItemByOrder(order);
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Integer getPriceOfAllOrderItems(Long id) {
        return  this.orderItemRepository.findOrderItemByOrder(orderRepository.findById(id).orElseThrow(OrderNotFoundException::new))
                .stream()
                .mapToInt(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                .sum();
    }


}
