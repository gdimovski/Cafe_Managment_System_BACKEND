package mk.ukim.finki.wpproekt.seminarska.service;

import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.Product;
import mk.ukim.finki.wpproekt.seminarska.model.enums.TableStatus;


import java.util.List;

public interface DeskService {


    Desk findById(Long id);
    List<Desk> findALl();
    Desk create(Long tableNumber, TableStatus status);
    Desk update(Long id, Long tableNumber, TableStatus status);
    Desk delete(Long id);



}
