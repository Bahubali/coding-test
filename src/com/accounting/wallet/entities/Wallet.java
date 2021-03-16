package com.accounting.wallet.entities;

import com.accounting.wallet.exceptions.WalletTransactionException;

import java.util.ArrayList;
import java.util.List;

public abstract class Wallet implements Account {

    private String walletId;
    protected Double balance;

    public Wallet(Double amount, String walletId) {
        this.balance = amount;
        this.walletId = walletId;
    }

    @Override
    public void credit(Double amount) throws WalletTransactionException {
        if (amount > 0) {
            this.balance = this.balance + amount;
        }
    }

    @Override
    public Double debit(Double amount) throws WalletTransactionException {
        if (this.balance < amount) {
            throw new WalletTransactionException("Insufficiant balance account");
        }
        this.balance = this.balance - amount;
        return amount;
    }

    @Override
    public Double getBalance() {
        return this.balance;
    }

    public abstract List<Transaction> getTransactions();
}
