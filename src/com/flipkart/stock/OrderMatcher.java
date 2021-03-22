package com.flipkart.stock;

import java.util.*;

public class OrderMatcher {

    private Map<String, List<Order>> orders;
    private TreeMap<Double, Map<String, List<Order>>> bids;
    private TreeMap<Double, Map<String, List<Order>>> offers;
    private Map<String, Stock> stockMap;
    private List<StockTransaction> stockTransactions;

    public OrderMatcher() {
        this.orders = new HashMap<>();
        this.bids = new TreeMap<>();
        this.offers = new TreeMap<>();
        this.stockTransactions = new ArrayList<>();
        this.stockMap = new HashMap<>();
    }

    public void match(Order order) {
        Double price = order.getPrice();
//        if (order.getStock() instanceof BuyStock) {
//            if (this.offers.containsKey(price)) {
//                List<Order> stockOffers = this.offers.get(price).get(order.getStock().getName());
//                if (!stockOffers.isEmpty()) {
//                    for (Order offerOrder: stockOffers) {
//                        if (offerOrder.getStock().getQuantity() > order.getStock().getQuantity()) {
//                            offerOrder.setStatus(Order.Status.PROCESSING);
//                            long offerQuantity = order.getBidQuantity();
//                            order.setAllocatedQuantity(offerQuantity);
//                            offerOrder.setAllocatedQuantity(offerQuantity);
//                            order.setStatus(Order.Status.PROCESSED);
//                            StockTransaction transact = StockTransaction.builder()
//                                    .sellOrderId(offerOrder.getOrderId())
//                                    .buyOrderId(order.getOrderId())
//                                    .quantity(offerQuantity)
//                                    .price(price).build();
//                            this.stockTransactions.add(transact);
//                        }
//                    }
//                }
//            }
//        }
//        for (Map.Entry<Double, Map<String, List<Order>>> offer: this.offers.entrySet()) {
//            if (offer.getKey() <= price) {
//                List<Order> stockOffers = this.offers.get(price).get(order.getStock().getName());
//                if (!stockOffers.isEmpty()) {
//                    for (Order offerOrder: stockOffers) {
//                        if (offerOrder.getRemainingQuantity() > order.getRemainingQuantity()) {
//                            offerOrder.setStatus(Order.Status.PROCESSING);
//                            long offerQuantity = order.getQuantity();
//                            order.setAllocatedQuantity(offerQuantity);
//                            offerOrder.setAllocatedQuantity(offerQuantity);
//                            order.setStatus(Order.Status.PROCESSED);
//                            StockTransaction transact = StockTransaction.builder()
//                                    .sellOrderId(offerOrder.getOrderId())
//                                    .buyOrderId(order.getOrderId())
//                                    .quantity(offerQuantity)
//                                    .price(price).build();
//                            this.stockTransactions.add(transact);
//                        }
//                    }
//                }
//                this.persistOrder(order);
//            }
//        }
    }

    public void matchOrder(Order order) {
        Double price = order.getPrice();
        switch (order.getType()) {
            case BUY:
                if (this.stockMap.containsKey(order.getStockKey())) {
                    Stock stock = this.stockMap.get(order.getStockKey());
                    for (Map.Entry<Double, List<Order>> offer: stock.getOffers().entrySet()) {
                        if (offer.getKey() <= price) {
                            List<Order> offerOrders = offer.getValue();
                            offerOrders.stream().forEach(offerOrder -> {
                                if (offerOrder.getRemainingQuantity() > order.getRemainingQuantity()) {
                                    offerOrder.setStatus(Order.Status.PROCESSING);
                                    long offerQuantity = order.getQuantity();
                                    order.setAllocatedQuantity(offerQuantity);
                                    offerOrder.setAllocatedQuantity(offerQuantity);
                                    order.setStatus(Order.Status.PROCESSED);
                                    StockTransaction transact = StockTransaction.builder()
                                            .sellOrderId(offerOrder.getOrderId())
                                            .buyOrderId(order.getOrderId())
                                            .quantity(offerQuantity)
                                            .price(price).build();
                                    this.stockTransactions.add(transact);
                                }
                                if (offerOrder.getRemainingQuantity() == 0) {
                                    offerOrders.remove(offerOrder);
                                }
                            });
                        }
                    }
                } else {
                    Stock stock = new Stock(order.getStockKey());
                    stock.addBid(order);
                    this.stockMap.put(stock.getName(), stock);
                }
                break;
            case SELL:
                if (this.stockMap.containsKey(order.getStockKey())) {

                } else {
                    Stock stock = new Stock(order.getStockKey());
                    stock.addOffer(order);
                    this.stockMap.put(stock.getName(), stock);
                }
                break;
            default:
        }
    }

    private void persistOrder(Order order) {
        if (order.getStatus() != Order.Status.PROCESSED) {
            switch (order.getType()) {
                case BUY:
                    break;
                case SELL:
                    break;
                default:
            }
        }
    }
}
