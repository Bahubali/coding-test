package com;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal( 13999);
        BigDecimal quantity = new BigDecimal(1);
        BigDecimal taxRate = new BigDecimal(9);
        calculateTax1(amount, quantity);
        calculateTax2(amount, quantity);
    }

    public static void calculateTax1(BigDecimal amount, BigDecimal quantity) {

        BigDecimal totalAmount = amount.multiply(quantity);
        BigDecimal totalTaxAmount = totalAmount.multiply(BigDecimal.valueOf(9)).divide(BigDecimal.valueOf(100))
                .setScale(3, RoundingMode.HALF_UP);

        System.out.println("Total tax amount 1 :"+totalTaxAmount);
        System.out.println("Total tax amount 1 :"+totalTaxAmount.divide(quantity));
    }

    public static void calculateTax2(BigDecimal amount, BigDecimal quantity) {

        BigDecimal taxRate = new BigDecimal(9);
        BigDecimal totalTaxAmount = amount.multiply(BigDecimal.valueOf(9)).divide(BigDecimal.valueOf(100))
                .setScale(3, RoundingMode.HALF_UP);

        System.out.println("Total tax amount 2 :"+amount);
        System.out.println("Total tax amount 2 :"+totalTaxAmount);
    }
}
