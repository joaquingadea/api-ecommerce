package com.joacog.ecommerce.controller;
import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final ISaleService saleService;
    @Autowired
    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }


    @PostMapping("/make")
    public String makeSale(@RequestBody List<Product> productList){
        return saleService.makeSale(productList);
    }

}
