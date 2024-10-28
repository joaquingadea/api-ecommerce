package com.joacog.ecommerce.service;

import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.model.Sale;
import com.joacog.ecommerce.repository.ISaleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class SaleService implements ISaleService{

    private ISaleRepository saleRepository;

    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public String makeSale(Set<Product> productList) {

        Sale newSale = new Sale();
        newSale.setProducts(productList);
        newSale.setSaleDate(LocalDate.now());

        saleRepository.save(newSale);
        return "Venta realizada";

    }
}
