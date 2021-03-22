package com.splitwise;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Transaction {
    private Double amount;
    private String description;
    private User paidBy;
    private Date createdAt;
    private List<User> splitAmong;
}
