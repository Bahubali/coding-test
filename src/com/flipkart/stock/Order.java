package com.flipkart.stock;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
@Builder
public class Order {
    enum OrderType {
        BUY, SELL;
    }
    enum Status {
        CREATED, PROCESSING, PROCESSED
    }
    private long orderId;
    private String stockKey;
    private Status status;
    private OrderType type;
    private Double price;
    private long allocatedQuantity;
    private long quantity;
    private Date createdAt;

    public long getRemainingQuantity() {
        return (this.quantity - this.allocatedQuantity);
    }
}
