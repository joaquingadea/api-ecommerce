package com.joacog.ecommerce.service;

import com.joacog.ecommerce.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface IProductService {
    public List<Product> getProducts();
    public void postProduct(Product product);
    public Product getProductById(Long id);
    public void deleteProductById(Long id);
    public void updateProduct(Product product);
}
