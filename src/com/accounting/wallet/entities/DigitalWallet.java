package com.accounting.wallet.entities;

import com.accounting.wallet.utils.DigitalWalletUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitalWallet extends Wallet {

    public User user;
    private List<Transaction> transactions = new ArrayList<>();
    public DigitalWallet(Double amount) {
        super(amount, DigitalWalletUtil.randomTransactionId());
    }

    @Override
    public List<Transaction> getTransactions() {
        return this.transactions;
    }
}
