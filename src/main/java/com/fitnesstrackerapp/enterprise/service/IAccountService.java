package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Account;

public interface IAccountService {

    Account fetchById(int accountId);

    Account save(Account account);
}
