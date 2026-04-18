package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dao.IAccountDAO;
import com.fitnesstrackerapp.enterprise.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceStub implements IAccountService {

    @Autowired
    private IAccountDAO accountDAO;

    public AccountServiceStub() {

    }

    public AccountServiceStub(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public Account fetchById(int accountId) {
        Account foundAccount = accountDAO.fetch(accountId);
        return foundAccount;
    }

    @Override
    public Account save(Account account) throws Exception {
        return accountDAO.save(account);
    }

    @Override
    public Account update(Account account, int accountId) throws Exception {
        return accountDAO.update(account, accountId);
    }

    @Override
    public void delete(int accountId) throws Exception {
        accountDAO.delete(accountId);
    }

    @Override
    public List<Account> fetchAll() {
        return accountDAO.fetchAll();
    }
}
