package com.splitwise;

import java.util.Date;

public abstract class Transaction {
    protected Double amount;
    protected String description;
    protected User paidBy;
    protected Date createdAt;
}
