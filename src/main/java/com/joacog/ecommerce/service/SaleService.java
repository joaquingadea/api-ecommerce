package com.joacog.ecommerce.service;

import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.model.Sale;
import com.joacog.ecommerce.repository.ISaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service

public class SaleService implements ISaleService{

    private final ISaleRepository saleRepository;

    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public String makeSale(List<Product> productList) {

        Sale newSale = new Sale();
        newSale.setSaleDate(LocalDate.now());

        saleRepository.save(newSale);
        return "Venta realizada";

    }
}
