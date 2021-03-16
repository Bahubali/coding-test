package com.accounting.wallet;

import com.accounting.wallet.entities.Transaction;
import com.accounting.wallet.entities.User;
import java.util.List;

public class DigitalWalletManager {

    private static final String CREATE_WALLET = "CreateWallet";
    private static final String TRANSFER_MONEY = "TransferMoney";
    private static final String STATEMENT = "Statement";

    public static void main(String[] args) {
       DigitalWalletService walletService  = new DigitalWalletService();
       walletService.addUser(new User("Bahubali", "Nandaganv", "bahubali.n@flipkart.com"));
       walletService.addUser(new User("Smita", "Patil", "smita.n@flipkart.com"));
       String commandType = "";

       try {
           User bahubali = walletService.createWallet("bahubali.n@flipkart.com", Double.valueOf(100));
           User smita = walletService.createWallet("smita.n@flipkart.com", Double.valueOf(50));
           Transaction transaction1 = Transaction.builder()
                   .fromWallet("bahubali.n@flipkart.com")
                   .toWallet("smita.n@flipkart.com")
                   .amount(Double.valueOf(10)).build();
           walletService.moneyTransfer(transaction1);
           System.out.println("Wallet balance of "+bahubali.getFirstName() + " is "+bahubali.getWallet().getBalance());
           System.out.println("Wallet balance of "+smita.getFirstName() + " is "+smita.getWallet().getBalance());
           switch (commandType) {
               case CREATE_WALLET:
                   User user = walletService.createWallet("bahubali.n@flipkart.com", Double.valueOf(100));
                   System.out.println("Created wallet for user, balance"+user.getWallet().getBalance());
                   break;
               case TRANSFER_MONEY:
                   Transaction transaction = Transaction.builder()
                           .fromWallet("bahubali.n@flipkart.com")
                           .toWallet("smita.n@flipkart.com")
                           .amount(Double.valueOf(10)).build();
                   walletService.moneyTransfer(transaction);
                   break;
               case STATEMENT:
                   List<Transaction> statements = walletService.getTransaction("smita.n@flipkart.com");
                   for (Transaction statement: statements) {
                       System.out.println(statement.toString());
                   }
                   break;
               default:
                   break;
           }
       } catch (Exception exception) {
           System.out.println(exception.getMessage());
       }
    }
}
