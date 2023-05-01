package com.example.paymentsystem.service;

import com.example.paymentsystem.model.Account;

import java.util.List;

public interface AccountService {

    Account getById(Long id);

    Account save(Account account);

    void delete(Long id);

    List<Account> getAll();
}
