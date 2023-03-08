package com.example.paymentsystem.service;

import com.example.paymentsystem.model.Account;
import com.example.paymentsystem.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired//Spring сам шукає підходящий бін і автоматично його інжектить
    private AccountRepository accountRepository;

    @Override
    public Account getById(Long id) {
        log.info("IN AccountServiceImpl getById {}", id);
        return accountRepository.findOne(id);
    }

    @Override
    public void save(Account account) {
        log.info("IN AccountServiceImpl save {}", account);
        accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        log.info("IN AccountServiceImpl delete {}", id);
        accountRepository.delete(id);
    }

    @Override
    public List<Account> getAll() {
        log.info("IN AccountServiceImpl findAll");
        return accountRepository.findAll();
    }
}
