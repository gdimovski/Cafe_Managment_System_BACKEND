package mk.ukim.finki.wpproekt.seminarska.web;

import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.OrderItem;
import mk.ukim.finki.wpproekt.seminarska.service.OrderService;
import mk.ukim.finki.wpproekt.seminarska.web.dto.OrderItemInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return this.orderService.findAll();
    }

    @GetMapping("/desk/{deskId}/orders/all")
    public List<OrderItem> getAllOrdersForDesk(@PathVariable Long deskId){
        return this.orderService.findAllOrderItemsByDeskId(deskId);
    }

    @GetMapping("/active")
    public List<Order> getAllActiveOrders(){
        return this.orderService.findAllActiveOrders();
    }


    @PostMapping("/desk/{deskId}/orders/create")
    public void addItemsToOrder(@PathVariable Long deskId, @RequestBody List<OrderItemInput> items){
        this.orderService.create(deskId, items);
    }


}
