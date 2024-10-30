package com.joacog.ecommerce.service;
import com.joacog.ecommerce.model.Product;
import java.util.List;

public interface ISaleService {

    String makeSale(List<Product> productList);
}
