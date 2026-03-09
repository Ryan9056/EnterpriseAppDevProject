package com.fitnesstrackerapp.enterprise.dto;

import lombok.Data;

/**
 * @author Tanner
 * dto with lombok for the Accounts, this will be used for log in and the goals will be connected using
 * the accountId
 */
public @Data class Account {
    private int accountId;
    private String accountName;
    private String email;
    private String password;
}
