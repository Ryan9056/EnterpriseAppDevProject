package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dao.AccountDAOStub;
import com.fitnesstrackerapp.enterprise.dao.IAccountDAO;
import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.service.AccountServiceStub;
import com.fitnesstrackerapp.enterprise.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AccountServiceTests {



    private IAccountService accountService;
    private Account testAccount;
    private Account updateAccount;

    @MockitoBean
    private IAccountDAO accountDAO;

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
        accountService.delete(1);
        assertNull(accountService.fetchById(1));
    }

    // create new account then update test account using new account
    private void updateTestAccount() throws Exception {
        updateAccount = new Account();
        updateAccount.setAccountId(2);
        updateAccount.setAccountName("updated");
        testAccount = accountService.update(updateAccount, updateAccount.getAccountId());
    }

    // create new account and save new account
    private void createTestAccount() throws Exception {
        testAccount = new Account();
        testAccount.setAccountId(1);
        testAccount.setAccountName("test");
        accountDAO = new AccountDAOStub();
        accountService = new AccountServiceStub(accountDAO);
        accountService.save(testAccount);
    }

    // fetch test account with id
    private void fetchTestAccount() {
        testAccount = accountService.fetchById(1);
    }

    // verify account is the correct
    private void returnTestAccount(String name) throws Exception {
        Account createdAccount = accountService.save(testAccount);
        assertEquals(name, createdAccount.getAccountName());
    }


}
