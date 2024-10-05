package com.joacog.ecommerce.repository;

import com.joacog.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
