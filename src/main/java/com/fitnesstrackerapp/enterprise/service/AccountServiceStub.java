package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountServiceStub implements IAccountService {
    @Override
    public Account fetchById(int accountId) {
        return null;
    }

    @Override
    public Account fetchByEmail(String email) throws Exception {
        return null;
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public  Account update(Account account) {return null;}

    @Override
    public void delete(int accountId){
    }

    @Override
    public List<Account> fetchAll() throws Exception {
        return List.of();
    }
}
