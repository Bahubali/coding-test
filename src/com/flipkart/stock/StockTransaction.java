package com.flipkart.stock;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockTransaction {
    private long sellOrderId;
    private long buyOrderId;
    private long quantity;
    private double price;
}
