package com.enterpriseapp.fitnesstracker.model;

public class Account {

    private int accountId;
    private String accountName;
    private String email;
    private String password;

    public Account(int accountId, String accountName, String email, String password) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.email = email;
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
