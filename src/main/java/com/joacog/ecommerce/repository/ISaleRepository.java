package com.joacog.ecommerce.repository;

import com.joacog.ecommerce.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale,Long> {
}
