package mk.ukim.finki.wpproekt.seminarska.web;


import mk.ukim.finki.wpproekt.seminarska.model.Desk;
import mk.ukim.finki.wpproekt.seminarska.model.Order;
import mk.ukim.finki.wpproekt.seminarska.model.enums.OrderStatus;
import mk.ukim.finki.wpproekt.seminarska.model.enums.TableStatus;
import mk.ukim.finki.wpproekt.seminarska.service.DeskService;
import mk.ukim.finki.wpproekt.seminarska.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class DeskController {

    @Autowired
    DeskService deskService;
    @Autowired
    OrderService orderService;

    @GetMapping("/desks")
    public List<Desk> getTables(){
        return deskService.findALl();
    }


    @PostMapping("/desks/create")
    public Desk createNewTable(){
        return deskService.create(10L, TableStatus.FREE);
    }

    @DeleteMapping("/desks/delete/{id}")
    public Desk deleteTable(@PathVariable Long id){
        return deskService.delete(id);
    }


}
