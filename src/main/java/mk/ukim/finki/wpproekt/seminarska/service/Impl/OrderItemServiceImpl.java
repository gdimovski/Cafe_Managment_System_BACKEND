package mk.ukim.finki.wpproekt.seminarska.service.Impl;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.OrderItem;
import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.DeskNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.repository.DeskRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.OrderItemRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.OrderRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.ProductRepository;
import mk.ukim.finki.wpproekt.seminarska.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final DeskRepository deskRepository;
    private final ProductRepository productRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderRepository orderRepository, DeskRepository deskRepository, ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.deskRepository = deskRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderItem create(Product product,Order order, Integer quantity) {
        return new OrderItem(product,order,quantity);
    }

    @Override
    public OrderItem update(Long id, Product product,Order order, Integer quantity) {
        OrderItem temp = this.findById(id);
        temp.setProduct(product);
        temp.setOrder(order);
        temp.setQuantity(quantity);
        return this.orderItemRepository.save(temp);

    }

    @Override
    public OrderItem delete(Long id) {
        OrderItem temp = this.findById(id);
        this.orderItemRepository.delete(temp);
        return temp;
    }

    @Override
    public OrderItem findById(Long id) {
        return this.orderItemRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<OrderItem> findAll() {
        return this.orderItemRepository.findAll();
    }

    @Override
    public List<OrderItem> findByOrder(Long orderId) {
        Order temp = this.orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        return this.orderItemRepository.findAll()
                .stream()
                .filter(orderItem -> orderItem.getOrder().getId().equals(temp.getId()))
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderItem> findByDesk(Long deskId) {

        Order tmp =  this.orderRepository.findAll()
                .stream()
                .filter(order -> order.getTable().getId().equals(deskId))
                .findFirst().orElseThrow(OrderNotFoundException::new);
        return this.orderItemRepository.findAll()
                .stream()
                .filter(orderItem -> orderItem.getOrder().getId().equals(tmp.getId()))
                .collect(Collectors.toList());
    }
}
