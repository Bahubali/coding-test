package com.splitwise;


import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class User {
    private String emailAddress;
    private String userName;
    private Double balance;
    private List<String> balanceSheet;
}
