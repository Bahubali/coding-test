package com.accounting.wallet.entities;

import com.accounting.wallet.exceptions.WalletTransactionException;
import java.util.*;
public interface Account {

    void credit(Double amount) throws WalletTransactionException;

    Double debit(Double amount) throws WalletTransactionException;

    List<Transaction> getTransactions();

    Double getBalance();
}
