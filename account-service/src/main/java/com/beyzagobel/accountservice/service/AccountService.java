package com.beyzagobel.accountservice.service;

import com.beyzagobel.accountservice.entity.Account;
import com.beyzagobel.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account get(String id){
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public ResponseEntity<Account> save(Account account){
        return ResponseEntity.ok(accountRepository.save(account));
    }

    public ResponseEntity<Account> update(String id, Account account){
        Account updateAccount = new Account();
        updateAccount.setUsername(account.getUsername());
        updateAccount.setPassword(account.getPassword());
        updateAccount.setCreatedAt(account.getCreatedAt());
        updateAccount.setActive(account.getActive());
        updateAccount.setEmail(account.getEmail());
        return ResponseEntity.ok(accountRepository.save(updateAccount));
    }

    public void delete(Account account){
        accountRepository.delete(account);
    }

    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }


}
