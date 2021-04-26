package mk.ukim.finki.wpproekt.seminarska.service.Impl;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.Receipt;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.DeskNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.model.exceptions.ReceiptNotFoundException;
import mk.ukim.finki.wpproekt.seminarska.repository.DeskRepository;

import mk.ukim.finki.wpproekt.seminarska.repository.OrderRepository;
import mk.ukim.finki.wpproekt.seminarska.repository.ReceiptRepository;
import mk.ukim.finki.wpproekt.seminarska.service.DeskService;
import mk.ukim.finki.wpproekt.seminarska.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final DeskRepository deskRepository;
    private final OrderRepository orderRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, DeskRepository deskRepository, OrderRepository orderRepository) {
        this.receiptRepository = receiptRepository;
        this.deskRepository = deskRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Receipt findById(Long id) {
        return this.receiptRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
    }

    @Override
    public Receipt create(Long orderId) {
        Order temp = this.orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        Receipt receipt = new Receipt(temp);
        return this.receiptRepository.save(receipt);
    }

    @Override
    public Receipt update(Long recId, Long orderId) {
        Receipt receipt = this.findById(recId);
        receipt.setOrder(this.orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new));
        return receipt;
    }


    @Override
    public Receipt delete(Long id) {
        Receipt receipt = this.findById(id);
        this.receiptRepository.delete(receipt);
        return receipt;
    }

    @Override
    public List<Receipt> findAll() {
        return this.receiptRepository.findAll();
    }

    @Override
    public List<Receipt> getBetweenDates(LocalDateTime first, LocalDateTime second) {
        return this.findAll()
                .stream()
                .filter(receipt -> receipt.getDatum().isAfter(first) && receipt.getDatum().isBefore(second))
                .collect(Collectors.toList());
    }




}
