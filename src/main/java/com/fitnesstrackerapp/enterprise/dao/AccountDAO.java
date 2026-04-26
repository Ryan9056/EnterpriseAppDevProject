package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Account;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data Access Object (DAO) for Account entities.
 * <p>
 * This class provides CRUD operations for Account objects using JPA and the EntityManager.
 * It is responsible for interacting directly with the database layer.
 */
@Slf4j
@Repository
public class AccountDAO implements IAccountDAO {

    /**
     * Injected JPA EntityManager used for database operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Fetches an Account by its unique identifier.
     *
     * @param accountId the unique ID of the account
     * @return the Account associated with the given ID
     * @throws RuntimeException if the ID is invalid or the account does not exist
     */
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

    /**
     * Persists a new Account to the database.
     *
     * @param account the Account object to be saved
     * @return the persisted Account
     * @throws RuntimeException if the account is null, has an existing ID,
     *                          or required fields are missing
     */
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

    /**
     * Updates an existing Account in the database.
     * <p>
     * Only fields provided (non-null and non-empty) will be updated.
     * Other fields will remain unchanged.
     *
     * @param account the Account object containing updated values
     * @return the updated Account entity
     * @throws RuntimeException if the account is null, has no ID,
     *                          or does not exist in the database
     */
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

    /**
     * Retrieves an Account by its email address.
     *
     * @param email the email associated with the account
     * @return the Account if found, or null if no account exists with the given email
     * @throws RuntimeException if an error occurs during query execution
     */
    @Override
    public Account fetchByEmail(String email) throws Exception {

        try {
            String jpql = "SELECT a FROM Account a WHERE a.email = :email";
            List<Account> results = entityManager.createQuery(jpql, Account.class)
                    .setParameter("email", email)
                    .getResultList();

            return results.isEmpty() ? null : results.get(0);

        } catch (Exception e) {
            throw new RuntimeException("Error fetching account by email", e);
        }
    }

    /**
     * Deletes an Account from the database by its ID.
     *
     * @param accountId the ID of the account to delete
     * @throws RuntimeException if the ID is invalid or the account does not exist
     */
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

    /**
     * Retrieves all Account records from the database.
     *
     * @return a list of all accounts; returns an empty list if none exist
     */
    @Override
    public List<Account> fetchAll() {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT a FROM Account a",
                Account.class
        );

        return query.getResultList();
    }
}
