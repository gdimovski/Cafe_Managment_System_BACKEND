package mk.ukim.finki.wpproekt.seminarska.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping
    public List<String> getTablePage(){

        List<String> products = new ArrayList<>();
        products.add("Product 1");
        products.add("Product 2");
        return products;
    }
}
