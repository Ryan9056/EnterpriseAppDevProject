package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dao.IAccountDAO;
import com.fitnesstrackerapp.enterprise.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountDAO accountDAO;

    @Override
    public Account fetchById(int accountId) throws Exception {
        return accountDAO.fetchById(accountId);
    }

    @Override
    public Account save(Account account) throws Exception {
        return accountDAO.save(account);
    }

    @Override
    public Account update(Account account) throws Exception {
        return accountDAO.update(account);
    }

    @Override
    public void delete(int accountId) throws Exception {
        accountDAO.delete(accountId);
    }

    @Override
    public List<Account> fetchAll() throws Exception {
        return accountDAO.fetchAll();
    }
}
