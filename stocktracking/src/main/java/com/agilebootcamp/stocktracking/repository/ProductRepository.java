package com.agilebootcamp.stocktracking.repository;

import com.agilebootcamp.stocktracking.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductId(int productId);
}
