package com.agilebootcamp.stocktracking.service;

import com.agilebootcamp.stocktracking.entity.Product;
import com.agilebootcamp.stocktracking.model.Response;

import java.util.List;

public interface ProductService {

    Response insert(Product product);
    Response update(Product product);
    Response deleteById(int id);
    Product findByProductId(int id);
    List<Product> findAll();

}
