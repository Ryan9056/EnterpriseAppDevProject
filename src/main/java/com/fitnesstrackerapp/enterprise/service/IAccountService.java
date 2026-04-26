package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Account;

import java.util.List;

/**
 * Service interface responsible for managing Account entities.
 * <p>
 * Defines business operations for retrieving, creating, updating,
 * and deleting account data.
 */

public interface IAccountService {

    /**
     * Retrieves an account using its unique identifier.
     *
     * @param accountId the ID of the account to retrieve
     * @return the Account associated with the given ID
     * @throws Exception if the account cannot be found or retrieved
     */
    Account fetchById(int accountId) throws Exception;

    /**
     * Retrieves an account by its email address.
     *
     * @param email the email associated with the account
     * @return the matching Account, or null if not found
     * @throws Exception if an error occurs during retrieval
     */
    Account fetchByEmail(String email) throws Exception;

    /**
     * Saves a new account to the system.
     *
     * @param account the Account to be created
     * @return the saved Account
     * @throws Exception if the account cannot be saved
     */
    Account save(Account account) throws Exception;

    /**
     * Updates an existing account.
     *
     * @param account the Account containing updated values
     * @return the updated Account
     * @throws Exception if the account cannot be found or updated
     */
    Account update(Account account) throws Exception;

    /**
     * Deletes an account by its ID.
     *
     * @param accountId the ID of the account to delete
     * @throws Exception if the account cannot be found or deleted
     */
    void delete(int accountId) throws Exception;

    /**
     * Retrieves all accounts in the system.
     *
     * @return a list of all accounts; returns an empty list if none exist
     * @throws Exception if an error occurs during retrieval
     */
    List<Account> fetchAll() throws Exception;
}
