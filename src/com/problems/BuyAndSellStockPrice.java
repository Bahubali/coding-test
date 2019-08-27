package com.problems;

import java.util.*;

/**
 * Created by bahubali.n on 28/12/18.
 */
public class BuyAndSellStockPrice {

    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(310.0,315.0,275.0,295.0,260.0,270.0,290.0,230.0,255.0,250.0);
//        Double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
//        Map<String, Double> stockProfit = new HashMap<String, Double>(){};
//        stockProfit.put("min_price", minPrice);
//        stockProfit.put("max_profit", maxProfit);
//        stockProfit.put("max_price", 0.0);
//        System.out.println("Min Price: "+computeRecursiveMaxProfit(prices, 0, prices.size()-1, stockProfit));
        System.out.println("Max Profit: "+computeMaxProfit(prices));

    }

    public static Double computeMaxProfit(List<Double> prices) {
        Double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for (Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    public static Double computeRecursiveMaxProfit(List<Double> prices, int l, int r, Map<String, Double> stockProfit) {
        if (l == r) return prices.get(l);
        Double min = 0.0, max = 0.0, minMax = 0.0;
        if (l < r) {
            int mid = l + (r - l)/2;
            min = computeRecursiveMaxProfit(prices, l, mid, stockProfit);
            max = computeRecursiveMaxProfit(prices, mid+1, r, stockProfit);

            stockProfit.put("max_profit", Math.max(stockProfit.get("max_profit"), max - min));
            if (l == 0) {
                stockProfit.put("min_price", Collections.min(Arrays.asList(stockProfit.get("min_price"), max, min)));
                return stockProfit.get("min_price");
            } else if (l == (prices.size()/2)) {
                stockProfit.put("max_price", Collections.max(Arrays.asList(max, min)));
                return stockProfit.get("max_price");
            }
        }
        return Math.max(min, max);
    }

    public static double buyAndSellStockTwice(List<Double> prices) {
        double maxTotalProfit = 0.0, minPriceSoFar = Double.MAX_VALUE;
        List<Double> firstBuySellProfits = new ArrayList<>();
        for (int i = 0; i < prices.size(); ++i) {
            minPriceSoFar = Math.min(prices.get(i), minPriceSoFar);
            maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPriceSoFar);
            firstBuySellProfits.add(maxTotalProfit);
        }

        double maxPriceSoFar = Double.MIN_VALUE;
        for (int i = prices.size()-1; i > 0; --i) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - prices.get(i) + firstBuySellProfits.get(i-1));
        }
        return maxTotalProfit;
    }
}
