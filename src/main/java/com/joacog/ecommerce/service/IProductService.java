package com.joacog.ecommerce.service;
import com.joacog.ecommerce.model.Product;
import java.util.List;


public interface IProductService {
    List<Product> getProducts();
    void postProduct(Product product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(Product product);
    Product updateProductByFields(Long id, Product productUpdates);
}
