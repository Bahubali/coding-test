package com.splitwise;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.*;

@AllArgsConstructor
@Builder
public class ExpenseTransaction extends Transaction {

    private SplitStrategy splitStrategy;
    private List<User> splitAmong;
}
