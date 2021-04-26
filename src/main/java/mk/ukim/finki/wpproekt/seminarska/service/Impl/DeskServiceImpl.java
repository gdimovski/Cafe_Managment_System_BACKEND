package mk.ukim.finki.wpproekt.seminarska.service.Impl;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.enums.OrderStatus;
import mk.ukim.finki.wpproekt.seminarska.model.enums.TableStatus;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.DeskNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.InvalidDeskIdException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.InvalidProductIdException;
import mk.ukim.finki.wpproekt.seminarska.repository.DeskRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.OrderRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.ProductRepository;
import mk.ukim.finki.wpproekt.seminarska.service.DeskService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
public class DeskServiceImpl implements DeskService {
    private final DeskRepository deskRepository;
    private final OrderRepository orderRepository;

    public DeskServiceImpl(DeskRepository deskRepository, OrderRepository orderRepository) {
        this.deskRepository = deskRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Desk findById(Long id) {
        return this.deskRepository.findById(id).orElseThrow(InvalidDeskIdException::new);
    }

    @Override
    public List<Desk> findALl() {
        return deskRepository.findAll();
    }

    @Override
    public Desk create(Long tableNumber, TableStatus status) {
        Desk desk = new Desk(tableNumber,status);
        return this.deskRepository.save(desk);
    }

    @Override
    public Desk update(Long id, Long tableNumber, TableStatus status) {
        Desk desk = this.deskRepository.findById(id).orElseThrow(InvalidDeskIdException::new);
        desk.setTableNumber(tableNumber);
        desk.setTableStatus(status);
        return this.deskRepository.save(desk);
    }

    @Override
    public Desk delete(Long id) {
        Desk desk = this.findById(id);
        this.deskRepository.delete(desk);
        return desk;
    }

    @Override
    public Order findOrder(Long id) {
        return null;
    }

//
//    @Override
//    public List<Order> findAllActiveOrders(Long id) {
//        return this.orderRepository.findAll()
//                .stream()
//                .filter(order -> order.getStatus().equals(OrderStatus.ACTIVE) && order.getTable().getId().equals(id))
//                .collect(Collectors.toList());
//    }


}
