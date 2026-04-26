package com.fitnesstrackerapp.enterprise.dao;
import com.fitnesstrackerapp.enterprise.dto.Account;
import java.util.List;

/**
 * Interface defining data access operations for Account entities.
 * <p>
 * Provides method signatures for CRUD operations and account retrieval.
 */
public interface IAccountDAO {
    /**
     * Saves a new Account to the database.
     *
     * @param account the Account to be persisted
     * @return the saved Account
     * @throws Exception if the account cannot be saved
     */
    Account save(Account account) throws Exception;

    /**
     * Retrieves an Account by its unique identifier.
     *
     * @param accountId the ID of the account
     * @return the Account associated with the given ID
     * @throws Exception if the account is not found or the ID is invalid
     */
    Account fetchById(int accountId) throws Exception;

    /**
     * Deletes an Account by its unique identifier.
     *
     * @param accountId the ID of the account to delete
     * @throws Exception if the account cannot be found or deleted
     */
    void delete(int accountId) throws Exception;

    /**
     * Retrieves all accounts from the database.
     *
     * @return a list of all accounts, or an empty list if none exist
     */
    List<Account> fetchAll();

    /**
     * Updates an existing Account.
     *
     * @param account the Account containing updated values
     * @return the updated Account
     * @throws Exception if the account cannot be found or updated
     */
    Account update(Account account) throws Exception;

    /**
     * Retrieves an Account by its email address.
     *
     * @param email the email associated with the account
     * @return the matching Account, or null if not found
     * @throws Exception if an error occurs during retrieval
     */
    Account fetchByEmail(String email) throws Exception;
}
