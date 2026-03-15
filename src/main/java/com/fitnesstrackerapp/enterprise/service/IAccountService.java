package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Account;
/**
 * Service interface responsible for managing Account objects.
 * Defines methods for retrieving and saving the accounts data.
 */

public interface IAccountService {
        /**
     * Retrieves an account using its unique identifier.
     *
     * @param accountId the id of the account to retrieve
     * @return the account object associated with the provided id
     */

    Account fetchById(int accountId);

    /**
     * Saves a new account or updates an existing account.
     *
     * @param account the account to save
     * @return the saved account object
     */

    Account save(Account account);
}
