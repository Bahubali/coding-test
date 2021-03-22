package com.splitwise;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SplitExact implements SplitStrategy {

    private final UserService userService;
    public void executeSplit(Transaction expense) throws Exception {
        BigDecimal amount = BigDecimal.valueOf(expense.getAmount());
        BigDecimal splitAmount = amount
                .divide(BigDecimal.valueOf(expense.getSplitAmong().size()+1), 2,RoundingMode.HALF_UP);

        List<String> usersIds = expense.getSplitAmong().stream().map(user -> user.getEmailAddress()).collect(Collectors.toList());
        String expenseSheet = new StringBuilder().append("You paid "+amount)
                .append(", shared by "+usersIds.toString()).toString();
        userService.updateBalanceSheet(expense.getPaidBy(), expenseSheet);
        String balanceSheet = new StringBuilder().append("You owe "+splitAmount)
                .append(", paid by "+expense.getPaidBy().getEmailAddress()).toString();

        Double remain = amount.subtract(
                splitAmount.multiply(BigDecimal.valueOf(expense.getSplitAmong().size()))
        ).doubleValue();
        BigDecimal balance = BigDecimal.valueOf(expense.getPaidBy().getBalance()).setScale(2);
        expense.getPaidBy().setBalance(balance.add(BigDecimal.valueOf(remain)).setScale(2).doubleValue());
        for (User user: expense.getSplitAmong()) {
            Double currentBalance = user.getBalance();
            user.setBalance(currentBalance - splitAmount.doubleValue());
            userService.updateBalanceSheet(user, balanceSheet);
        }

    }
}
