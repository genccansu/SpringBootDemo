package com.agilebootcamp.stocktracking.repository;

import com.agilebootcamp.stocktracking.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    Stock findByProductId(int productId);
}
