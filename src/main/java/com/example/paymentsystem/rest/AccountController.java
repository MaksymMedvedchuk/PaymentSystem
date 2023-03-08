package com.example.paymentsystem.rest;


import com.example.paymentsystem.model.Account;
import com.example.paymentsystem.model.Client;
import com.example.paymentsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable(name = "accountId") Long clientId) {
        Account account = accountService.getById(clientId);
        return account != null
                ? new ResponseEntity<>(account, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "accountId") Long accountId) {
        boolean deleted = accountService.delete(accountId);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAll(){
        List<Account> accounts = accountService.getAll();

        return accounts != null && !accounts.isEmpty()
                ? new ResponseEntity<>(accounts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
