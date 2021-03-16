package com.accounting.wallet;

import com.accounting.wallet.entities.*;

import java.util.*;

public class DigitalWalletService {

    private Map<String, User> users = new HashMap<>();
    private Map<Account, List<Transaction>> walletTransactions;

    public User createWallet(String user, Double amount) throws Exception {
        User accountHolder = getUser(user);
        if (accountHolder.getWallet() != null) {
            throw new Exception("Wallet is already created for user,"+user);
        }
        Account digitalWallet = new DigitalWallet(amount);
        accountHolder.setWallet(digitalWallet);
        return accountHolder;
    }

    public void moneyTransfer(Transaction transaction) throws Exception {
        User fromUser = getUser(transaction.getFromWallet());
        User toUser = getUser(transaction.getToWallet());
        if (fromUser.getWallet() == null || toUser.getWallet() == null) {
            throw new Exception("Failed, one of user doesn't have account");
        }
        Double debitAmount = fromUser.getWallet().debit(transaction.getAmount());
        toUser.getWallet().credit(debitAmount);
    }

    public List<Transaction> getTransaction(String user) throws Exception {
        User accountHolder = getUser(user);
        return accountHolder.getWallet().getTransactions();
    }

    public void addUser(User user) {
        this.users.put(user.getEmailAddress(), user);
    }

    public User getUser(String email) throws Exception {
        if (users.containsKey(email)) {
            return users.get(email);
        } else {
            throw new Exception("User doesn't exist");
        }
    }
}
