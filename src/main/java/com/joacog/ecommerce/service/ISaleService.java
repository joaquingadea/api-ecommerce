package com.joacog.ecommerce.service;
import com.joacog.ecommerce.model.Product;
import java.util.Set;

public interface ISaleService {

    public String makeSale(Set<Product> productList);
}
