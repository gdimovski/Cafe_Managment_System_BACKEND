package mk.ukim.finki.wpproekt.seminarska.web;

import mk.ukim.finki.wpproekt.seminarska.model.Receipt;
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
        return this.receiptService.create(orderId);

    }
}
