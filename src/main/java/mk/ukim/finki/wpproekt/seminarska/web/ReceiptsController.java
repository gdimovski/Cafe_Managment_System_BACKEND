package mk.ukim.finki.wpproekt.seminarska.web;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.Receipt;
import mk.ukim.finki.wpproekt.seminarska.model.enums.OrderStatus;
import mk.ukim.finki.wpproekt.seminarska.model.enums.TableStatus;
import mk.ukim.finki.wpproekt.seminarska.service.DeskService;
import mk.ukim.finki.wpproekt.seminarska.service.OrderService;
import mk.ukim.finki.wpproekt.seminarska.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ReceiptsController {

    @Autowired
    ReceiptService receiptService;

    @Autowired
    DeskService deskService;

    @Autowired
    OrderService orderService;


    @GetMapping("/receipts")
    public List<Receipt> getAllReceipts()
    {
        return this.receiptService.findAll();

    }


    @DeleteMapping("/receipts/delete/{id}")
    public Receipt deleteReceipt(@PathVariable Long id)
    {
        return this.receiptService.delete(id);

    }


    @PostMapping("/orders/{orderId}/receipts/create")
    public Receipt createReceiptForOrder(@PathVariable Long orderId)
    {
        Order order = orderService.findById(orderId);
        orderService.update(orderId,order.getTable(), OrderStatus.CLOSED);
        Desk desk = deskService.findById(order.getTable().getId());
        deskService.update(desk.getId(),desk.getTableNumber(), TableStatus.FREE);
        return this.receiptService.create(orderId);

    }
}
