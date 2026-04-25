package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class AccountServiceTests {


    @Autowired
    private IAccountService accountService;
    private Account templateAccount;
    private Account testAccount;
    private Account updateAccount;

    // Test for creating, fetching, and verifying creation of Account using account name and id
    @Test
    void createAccount_returnsTestAccount() throws Exception {
        createTestAccount();
        fetchTestAccount();
        returnTestAccount("test");
    }

    // Test for creating, fetching, updating, and verifying creation of account using account name and id
    @Test
    void updateAccount_returnsUpdatedAccount() throws Exception {
        createTestAccount();
        fetchTestAccount();
        updateTestAccount();
        returnTestAccount("updated");
    }

    // Test for creating, deleting and verifying deletion of an account using account name and id
    @Test
    void deleteAccount_returnsNull() throws Exception {
        createTestAccount();
        deleteTestAccount();
    }

    // delete account using account id then checking is account is null
    private void deleteTestAccount() throws Exception {
        accountService.delete(templateAccount.getAccountId());
        assertNull(accountService.fetchById(templateAccount.getAccountId()));
    }

    // create new account then update test account using new account
    private void updateTestAccount() throws Exception {
        updateAccount = new Account();
        updateAccount.setAccountId(2);
        updateAccount.setAccountName("updated");
        testAccount = accountService.update(updateAccount);
    }

    // create new account and save new account
    private void createTestAccount() throws Exception {
        templateAccount = new Account();
        templateAccount.setAccountId(1);
        templateAccount.setAccountName("test");
        accountService.save(templateAccount);
    }

    // fetch test account with id
    private void fetchTestAccount() throws Exception {
        testAccount = accountService.fetchById(templateAccount.getAccountId());
    }

    // verify account is the correct
    private void returnTestAccount(String name) {
        String accountName = testAccount.getAccountName();
        assertEquals(name, accountName);
    }


}
