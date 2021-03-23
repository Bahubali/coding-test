package com.flipkart.stock;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

@Data
public class Stock {

    private double price;
    private String name;
    private TreeMap<Double, List<Order>> bids;
    private TreeMap<Double, List<Order>> offers;
    public Stock(String stockKey) {
        this.name = stockKey;
        this.bids = new TreeMap<>(Comparator.reverseOrder());
        this.offers = new TreeMap<>();
    }

    public TreeMap<Double, List<Order>> getBids() {
        return this.bids;
    }

    public TreeMap<Double, List<Order>> getOffers() {
        return this.offers;
    }

    public void addBid(Order order) {
        if (this.bids.containsKey(order.getPrice())) {
            this.bids.get(order.getPrice()).add(order);
        } else {
            List<Order> orders = new ArrayList<>();
            orders.add(order);
            this.bids.put(order.getPrice(), orders);
        }
    }

    public void addOffer(Order order) {
        if (this.offers.containsKey(order.getPrice())) {
            this.offers.get(order.getPrice()).add(order);
        } else {
            List<Order> orders = new ArrayList<>();
            orders.add(order);
            this.offers.put(order.getPrice(), orders);
        }
    }
//    private long quantity;
}
