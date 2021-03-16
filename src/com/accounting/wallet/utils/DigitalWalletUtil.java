package com.accounting.wallet.utils;

import java.util.UUID;

public class DigitalWalletUtil {

    public static String generateWalletId(){
        return UUID.fromString("abcdefghijklmnopqrstuvwaxyz0123456789").toString();
    }

    public static String randomTransactionId(){
        return UUID.randomUUID().toString();
    }
}
