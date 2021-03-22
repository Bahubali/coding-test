package com.splitwise;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class ExpenseManager {
    private final UserService userService;
    private HashMap<String, List<Transaction>> transactionHashMap;

    ExpenseManager(@NonNull final UserService userService) {
        this.userService = userService;
        this.transactionHashMap = new HashMap<>();
    }

    public void execute(Command command) {
        try {
            switch (command.getType()) {
                case EXPENSE:
                    User paidBy = userService.getUser(command.getPaidBy());
                    List<User> peerUsers = userService.getUsers(command.getSplitAmong());

                    Transaction transaction = Transaction.builder()
                            .amount(command.getAmount())
                            .paidBy(paidBy)
                            .splitAmong(peerUsers)
                            .build();
                    addTransaction(transaction);
                    SplitStrategy splitStrategy = getSplitStrategy(command);
                    splitStrategy.executeSplit(transaction);
                    break;
                case SHOW:
                    break;
                default:
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private SplitStrategy getSplitStrategy(Command command) {
        SplitStrategy splitStrategy = null;
        switch (command.getExpenseType()) {
            case EXACT:
                splitStrategy = new SplitExact(userService);
                break;
            default:

        }
        return splitStrategy;
    }

    private void addTransaction(Transaction transaction) {
        if (transactionHashMap.containsKey(transaction.getPaidBy())) {
            transactionHashMap.get(transaction.getPaidBy()).add(transaction);
        } else {
            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);
            transactionHashMap.put(transaction.getPaidBy().getEmailAddress(), transactions);
        }
    }

    public static void main(String[] args) {
        try {
            UserService userService = new UserService();
            userService.addUser(User.builder()
                    .userName("Bahubali")
                    .emailAddress("bahubali.n@flipkart.com")
                    .balance(0.0d).build()
            );
            userService.addUser(User.builder()
                    .userName("Smita")
                    .emailAddress("smita.n@flipkart.com")
                    .balance(0.0d).build()
            );
            userService.addUser(User.builder()
                    .userName("Arun")
                    .emailAddress("arun.t@flipkart.com")
                    .balance(0.0d).build()
            );
            ExpenseManager expenseManager = new ExpenseManager(userService);
            Command command = Command.builder()
                    .amount(100.0d)
                    .expenseType(Command.ExpenseType.EXACT)
                    .type(Command.CommandType.EXPENSE)
                    .paidBy("bahubali.n@flipkart.com")
                    .noOfUsers(2).splitAmong(Arrays.asList("smita.n@flipkart.com","arun.t@flipkart.com"))
                    .build();
            expenseManager.execute(command);
            Command command1 = Command.builder()
                    .amount(50.00d)
                    .expenseType(Command.ExpenseType.EXACT)
                    .type(Command.CommandType.EXPENSE)
                    .paidBy("smita.n@flipkart.com")
                    .noOfUsers(1).splitAmong(Arrays.asList("bahubali.n@flipkart.com"))
                    .build();
            expenseManager.execute(command1);
            for (User user: userService.getAllUsers()) {
                System.out.println(user.getEmailAddress() +" balance is "+user.getBalance());
                if (user.getBalanceSheet() != null)
                    user.getBalanceSheet().stream().forEach(sh -> System.out.println(sh));
                System.out.println("******************************************************");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
