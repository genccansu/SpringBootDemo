package com.agilebootcamp.stocktracking.controller;

import com.agilebootcamp.stocktracking.model.Response;
import com.agilebootcamp.stocktracking.model.StockItem;
import com.agilebootcamp.stocktracking.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping(path = "/buy")
    public Response buy(@RequestBody StockItem stockItem){
        return stockService.buy(stockItem);
    }

    @PostMapping(path = "/sell")
    public Response sell(@RequestBody StockItem stockItem){
        return  stockService.sell(stockItem);
    }

}
