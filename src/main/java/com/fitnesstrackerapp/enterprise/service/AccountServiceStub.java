package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceStub implements IAccountService {
    @Override
    public Account fetchById(int accountId) {
        return null;
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public void update(int accountId, Account account) {

    }

    @Override
    public void delete(int accountId) {

    }
}
