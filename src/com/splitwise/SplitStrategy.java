package com.splitwise;

public interface SplitStrategy {

    public void executeSplit(Transaction transaction) throws Exception;
}
