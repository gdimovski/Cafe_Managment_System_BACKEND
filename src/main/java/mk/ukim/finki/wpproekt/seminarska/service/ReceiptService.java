package mk.ukim.finki.wpproekt.seminarska.service;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.Receipt;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

public interface ReceiptService {

    Receipt findById(Long id);
    Receipt create(Long orderId);
    Receipt update(Long recId, Long orderId);
    Receipt delete(Long id);
    List<Receipt> findAll();
    List<Receipt> getBetweenDates(LocalDateTime first,LocalDateTime second);

}

