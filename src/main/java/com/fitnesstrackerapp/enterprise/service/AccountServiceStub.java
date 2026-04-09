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
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account update(int accountId) {
        return null;
    }

    @Override
    public void delete(int accountId) {

    }
}
