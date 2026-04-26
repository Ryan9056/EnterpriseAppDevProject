package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.*;

/**
 * Represents an Account entity in the system.
 * <p>
 * This class is mapped to the "accounts" table and stores user information
 * used for authentication and association with goals.
 * Each account can be linked to multiple goals via the accountId field.
 *
 * @author Tanner
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(nullable = false)
    private String accountName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Account(){}

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getAccountName() { return accountName; }
    public void setAccountName(String accountName) { this.accountName = accountName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            return ((Account) obj).getAccountId() == this.accountId;
        }
        return false;
    }
}
