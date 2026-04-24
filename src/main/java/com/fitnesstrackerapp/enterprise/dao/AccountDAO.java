package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Account;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO implements IAccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account fetchById(int accountId) throws Exception {
        return entityManager.find(Account.class, accountId);
    }

    @Override
    @Transactional
    public Account save(Account account) throws Exception {
        if (account.getAccountId() == 0) {
            entityManager.persist(account);
            return account;
        } else {
            return entityManager.merge(account);
        }
    }

    @Override
    @Transactional
    public Account update(Account account) throws Exception {

        Account existing = entityManager.find(Account.class, account.getAccountId());

        if (existing == null) {
            throw new RuntimeException("Account not found");
        }

        // only update fields that are provided
        if (account.getEmail() != null) {
            existing.setEmail(account.getEmail());
        }

        if (account.getAccountName() != null) {
            existing.setAccountName(account.getAccountName());
        }

        // DO NOT overwrite password unless explicitly provided
        if (account.getPassword() != null) {
            existing.setPassword(account.getPassword());
        }

        return entityManager.merge(existing);
    }

    @Override
    @Transactional
    public void delete(int accountId) throws Exception {
        Account account = entityManager.find(Account.class, accountId);

        if (account != null) {
            entityManager.remove(account);
        }
    }

    @Override
    public List<Account> fetchAll() {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT a FROM Account a",
                Account.class
        );

        return query.getResultList();
    }
}
