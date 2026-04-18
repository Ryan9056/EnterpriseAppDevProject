package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountDAOStub implements IAccountDAO {

    Map<Integer, Account> allAccounts = new HashMap<>();

    @Override
    public Account save(Account account) throws Exception {
        int accountId = account.getAccountId();
        allAccounts.put(accountId,account);
        return account;
    }

    @Override
    public Account fetch(int accountId) {
        return allAccounts.get(accountId);
    }

    @Override
    public void delete(int accountId) throws Exception {
        allAccounts.remove(accountId);
    }

    @Override
    public List<Account> fetchAll() {
        List<Account> returnAccounts = new ArrayList(allAccounts.values());
        return returnAccounts;
    }

    @Override
    public Account update(Account account, int accountId) throws Exception {
        allAccounts.put(accountId, account);
        return account;
    }
}
