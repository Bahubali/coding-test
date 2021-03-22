package com.splitwise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Command {
    private final CommandType type;
    private final Double amount;
    private final String paidBy;
    private final int noOfUsers;
    private final ExpenseType expenseType;
    private List<String> splitAmong;

    enum CommandType {
        EXPENSE,SHOW
    }

    enum ExpenseType {
        EQUAL, EXACT, PERCENT;
    }
}
