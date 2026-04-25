package com.fitnesstrackerapp.enterprise.dao;
import com.fitnesstrackerapp.enterprise.dto.Account;
import java.util.List;

public interface IAccountDAO {
    Account save(Account account) throws Exception;

    Account fetchById(int accountId) throws Exception;

    void delete(int accountId) throws Exception;

    List<Account> fetchAll();

    Account update(Account account) throws Exception;

    Account fetchByEmail(String email) throws Exception;
}
