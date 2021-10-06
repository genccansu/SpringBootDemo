package com.agilebootcamp.stocktracking.service;

import com.agilebootcamp.stocktracking.entity.Product;
import com.agilebootcamp.stocktracking.model.Response;
import com.agilebootcamp.stocktracking.model.StockItem;

public interface StockService {
    Response buy(StockItem stockItem);
    Response sell(StockItem stockItem);
}
