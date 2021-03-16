package com.splitwise;

public interface SplitStrategy {

    public void executeSplit(ExpenseTransaction expense) throws Exception;
}
