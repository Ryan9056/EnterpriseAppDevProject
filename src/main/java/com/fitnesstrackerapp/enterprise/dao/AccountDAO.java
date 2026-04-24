package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Account;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO implements IAccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account fetchById(int accountId) {

        if (accountId <= 0) {
            throw new RuntimeException("Invalid account id");
        }

        Account account = entityManager.find(Account.class, accountId);

        if (account == null) {
            throw new RuntimeException("Account not found with id: " + accountId);
        }

        return account;
    }

    @Override
    @Transactional
    public Account save(Account account) {

        if (account == null) {
            throw new RuntimeException("Account cannot be null");
        }

        if (account.getAccountId() != 0) {
            throw new RuntimeException("New account should not already have an id");
        }

        if (account.getAccountName() == null || account.getAccountName().trim().isEmpty()) {
            throw new RuntimeException("Account name is required");
        }

        if (account.getEmail() == null || account.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Account email is required");
        }

        if (account.getPassword() == null || account.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Account password is required");
        }

        entityManager.persist(account);
        return account;
    }

    @Override
    @Transactional
    public Account update(Account account) {

        if (account == null) {
            throw new RuntimeException("Account cannot be null");
        }

        if (account.getAccountId() == 0) {
            throw new RuntimeException("Account must have an id to be updated");
        }

        Account existing = entityManager.find(Account.class, account.getAccountId());

        if (existing == null) {
            throw new RuntimeException("Account not found with id: " + account.getAccountId());
        }

        // only update fields that are provided
        if (account.getEmail() != null && !account.getEmail().trim().isEmpty()) {
            existing.setEmail(account.getEmail());
        }

        if (account.getAccountName() != null && !account.getAccountName().trim().isEmpty()) {
            existing.setAccountName(account.getAccountName());
        }

        // DO NOT overwrite password unless explicitly provided
        if (account.getPassword() != null && !account.getPassword().trim().isEmpty()) {
            existing.setPassword(account.getPassword());
        }

        return existing; // JPA should persist changes automatically
    }

    @Override
    @Transactional
    public void delete(int accountId) {

        if (accountId <= 0) {
            throw new RuntimeException("Invalid account id");
        }

        Account account = entityManager.find(Account.class, accountId);

        if (account == null) {
            throw new RuntimeException("Account not found with id: " + accountId);
        }

        entityManager.remove(account);
    }

    @Override
    public List<Account> fetchAll() {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT a FROM Account a",
                Account.class
        );

        return query.getResultList();
    }
}
