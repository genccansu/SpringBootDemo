package com.agilebootcamp.stocktracking.service.impl;

import com.agilebootcamp.stocktracking.entity.Stock;
import com.agilebootcamp.stocktracking.model.Response;
import com.agilebootcamp.stocktracking.model.StockItem;
import com.agilebootcamp.stocktracking.repository.StockRepository;
import com.agilebootcamp.stocktracking.service.ProductService;
import com.agilebootcamp.stocktracking.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductService productService;



    @Override
    public Response buy(StockItem stockItem) {
        Response response = new Response();

        try{
            if(Objects.isNull(productService.findByProductId(stockItem.getProductId())))
                throw new Exception("Ürün kaydi bulunamadi.");
            Stock stock =stockRepository.findByProductId(stockItem.getProductId());
            if(Objects.isNull(stock)) {
                Stock newStock = new Stock();
                newStock.setProductId(stockItem.getProductId());
                newStock.setQuantity(stockItem.getQuantity());
                Stock buyStock =  stockRepository.save(newStock);
                response.setMessage("Ürün stoga eklendi.");
                response.setData(buyStock);
            } else {
                int newQuantity = stock.getQuantity() + stockItem.getQuantity();
                stock.setQuantity(newQuantity);
                stockRepository.save(stock);


            }
        }catch (Exception e){
            response.setCode(100);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Response sell(StockItem stockItem) {
        Response response = new Response();
        try{
            Stock stock = stockRepository.findByProductId(stockItem.getProductId());
            if(Objects.isNull(stock)) throw new Exception("Stokta ürün bulunmamaktadır");
            if(stockItem.getQuantity()>stock.getQuantity()) throw new Exception("Stokta yeterli miktarda ürün bulunmamaktadir.");

            int newQuantity = stock.getQuantity() - stockItem.getQuantity();
            stock.setQuantity(newQuantity);
           Stock sellStock = stockRepository.save(stock);
            response.setMessage("Ürün satildi.");
            response.setData(sellStock);
        }catch (Exception e){
            response.setCode(101);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
