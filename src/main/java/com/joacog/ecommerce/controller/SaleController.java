package com.joacog.ecommerce.controller;
import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.model.Sale;
import com.joacog.ecommerce.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final ISaleService saleService;
    @Autowired
    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    //MODIFICAR ESTA FUNCIONALIDAD
    @PostMapping("/make")
    public String makeSale(@RequestBody List<Product> productList){
        return saleService.makeSale(productList);
    }

    @GetMapping("/get")
    public List<Sale> getSaleList(){
        return saleService.getSaleList();
    }
}
