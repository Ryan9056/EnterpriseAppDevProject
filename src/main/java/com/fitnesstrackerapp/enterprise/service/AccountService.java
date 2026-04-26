package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dao.IAccountDAO;
import com.fitnesstrackerapp.enterprise.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Account operations.
 * <p>
 * This class acts as the business logic layer for Account entities,
 * delegating data access operations to the AccountDAO.
 */
@Service
public class AccountService implements IAccountService{

    /**
     * DAO used to perform database operations for Account entities.
     */
    @Autowired
    private IAccountDAO accountDAO;

    /**
     * Retrieves an account by its ID.
     *
     * @param accountId the ID of the account
     * @return the Account associated with the given ID
     * @throws Exception if the account cannot be found or retrieved
     */
    @Override
    public Account fetchById(int accountId) throws Exception {
        return accountDAO.fetchById(accountId);
    }

    /**
     * Retrieves an account by email.
     *
     * @param email the email associated with the account
     * @return the matching Account, or null if not found
     * @throws Exception if an error occurs during retrieval
     */
    @Override
    public Account fetchByEmail(String email) throws Exception {
        return accountDAO.fetchByEmail(email);
    }

    /**
     * Saves a new account.
     *
     * @param account the Account to be created
     * @return the saved Account
     * @throws Exception if the account cannot be saved
     */
    @Override
    public Account save(Account account) throws Exception {
        return accountDAO.save(account);
    }

    /**
     * Updates an existing account.
     *
     * @param account the Account containing updated values
     * @return the updated Account
     * @throws Exception if the account cannot be updated
     */
    @Override
    public Account update(Account account) throws Exception {
        return accountDAO.update(account);
    }

    /**
     * Deletes an account by its ID.
     *
     * @param accountId the ID of the account to delete
     * @throws Exception if the account cannot be deleted
     */
    @Override
    public void delete(int accountId) throws Exception {
        accountDAO.delete(accountId);
    }

    /**
     * Retrieves all accounts in the system.
     *
     * @return a list of all accounts
     * @throws Exception if an error occurs during retrieval
     */
    @Override
    public List<Account> fetchAll() throws Exception {
        return accountDAO.fetchAll();
    }
}
