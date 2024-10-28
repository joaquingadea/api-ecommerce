package com.joacog.ecommerce.controller;

import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

public class SaleController {

    private ISaleService saleService;
    @Autowired
    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    public String makeSale(@RequestBody Set<Product> productList){
        return saleService.makeSale(productList);
    }

}
