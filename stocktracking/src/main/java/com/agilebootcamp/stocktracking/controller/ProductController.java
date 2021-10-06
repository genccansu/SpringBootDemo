package com.agilebootcamp.stocktracking.controller;

import com.agilebootcamp.stocktracking.entity.Product;
import com.agilebootcamp.stocktracking.model.Response;
import com.agilebootcamp.stocktracking.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/api/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Response insert(@RequestBody Product product){
       return productService.insert(product);
    }

    @PutMapping
    public Response update(@RequestBody Product product){
       return productService.update(product);
    }

    @DeleteMapping(path = "/{id}")
    public Response deleteById(@PathVariable int id){
        return productService.deleteById(id);
    }

    @GetMapping(path = "/{id}")
    public Product findById(@RequestParam int id){
       return productService.findByProductId(id);
    }

    @GetMapping(path="/findall")
    public List<Product> allFind(){
        return productService.findAll();
    }




}
