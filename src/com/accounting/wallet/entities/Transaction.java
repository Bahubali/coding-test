package com.accounting.wallet.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {

    private String id;

    private String fromWallet;

    private String toWallet;

    private Double amount;

    private String type;
}
