package com.agilebootcamp.stocktracking.service.impl;

import com.agilebootcamp.stocktracking.entity.Product;
import com.agilebootcamp.stocktracking.model.Response;
import com.agilebootcamp.stocktracking.repository.ProductRepository;
import com.agilebootcamp.stocktracking.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    Response response = new Response();

    @Override
    public Response insert(Product product) {

        try{
           Product insertedProduct =  productRepository.save(product);
            response.setData(insertedProduct);
            response.setCode(0);
            response.setMessage("ürün eklendi.");

        } catch (Exception e){

            response.setCode(1);
            response.setMessage("Ürün eklenirken hata oluştu.");
        }
        return response;
    }

    @Override
    public Response deleteById(int id) {

        try {
           productRepository.deleteById(id);
            response.setCode(0);
            response.setMessage("Ürün silindi.");

        } catch (Exception e){
            response.setCode(1);
            response.setMessage("Ürün silinirken bir hata olustu.");
        }
         return response;

    }

    @Override
    public Product findByProductId(int productId) {
        Product product = productRepository.findByProductId(productId);
        if(!Objects.isNull(product)){
            return product;
        }
        return null;
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

   @Override
    public Response update(Product recentProduct) {
        Response response = new Response();
        try{
           Product product= productRepository.findByProductId(recentProduct.getProductId());
           if(Objects.isNull(recentProduct)) throw new Exception("Ürün bulunamadi.");
           product.setName(recentProduct.getName());
           product.setSerialNumber(recentProduct.getSerialNumber());
           Product updatedProduct = productRepository.save(product);
            response.setData(updatedProduct);
            response.setMessage("Ürün Güncellendi. ");
        }catch (Exception e){
            response.setCode(103);
            response.setMessage(e.getMessage());
        }
        return response;
   }


    }


