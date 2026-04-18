package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDAO {
    Account save(Account account) throws Exception;

    Account fetch(int accountId);

    void delete(int accountId) throws Exception;

    List<Account> fetchAll();

    Account update(Account account, int accountId) throws Exception;
}
