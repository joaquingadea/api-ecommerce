package com.joacog.ecommerce.service;

import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class ProductService implements IProductService{

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void postProduct(Product product) {
        productRepository.save(product);
    }
}