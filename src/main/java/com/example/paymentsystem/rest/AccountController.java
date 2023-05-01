package com.example.paymentsystem.rest;


import com.example.paymentsystem.model.Account;
import com.example.paymentsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable(name = "accountId") Long accountId) {
        Account account = accountService.getById(accountId);
        return account != null
                ? new ResponseEntity<>(account, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        Account result = accountService.save(account);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable(name = "accountId") Long accountId) {
        accountService.delete(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAll() {
        List<Account> accounts = accountService.getAll();
        return accounts != null && !accounts.isEmpty()
                ? new ResponseEntity<>(accounts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
