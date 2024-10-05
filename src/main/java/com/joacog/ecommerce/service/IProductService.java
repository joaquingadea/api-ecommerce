package com.joacog.ecommerce.service;

import com.joacog.ecommerce.model.Product;

import java.util.List;
import java.util.Set;

public interface IProductService {
    public List<Product> getProducts();
    public void postProduct(Product product);
}
