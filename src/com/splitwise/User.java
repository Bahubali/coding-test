package com.splitwise;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String emailAddress;
    private String userName;
    private String lastName;
    private String phoneNumber;
    private Address address;

    public class Address {
        private String houseNo;
        private String addressLine1;
        private String addressLine2;
        private String state;
        private Integer pinCode;
    }
}
