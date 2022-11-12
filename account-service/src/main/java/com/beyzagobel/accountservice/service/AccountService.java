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

    public ResponseEntity<Account> get(String id){
        return ResponseEntity.ok(accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException()));
    }

    public ResponseEntity<Account> save(Account account){
        return ResponseEntity.ok(accountRepository.save(account));
    }

    public ResponseEntity<Account> update(String id, Account account){
        Assert.isNull(id, "Id cannot be null");
        return ResponseEntity.ok(accountRepository.save(account));
    }

    public void delete(Account account){
        accountRepository.delete(account);
    }

    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }


}
