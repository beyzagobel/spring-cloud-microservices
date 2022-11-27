package com.beyzagobel.accountservice.service;

import com.beyzagobel.accountservice.dto.AccountDTO;
import com.beyzagobel.accountservice.entity.Account;
import com.beyzagobel.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    public Account get(String id){
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public ResponseEntity<Account> save(AccountDTO accountDTO){
        Account account = this.modelMapper.map(accountDTO, Account.class);
        return ResponseEntity.ok(accountRepository.save(account));
    }

    public ResponseEntity<Account> update(String id, AccountDTO accountDTO){
        Account account = this.modelMapper.map(accountDTO, Account.class);
        Account updateAccount = new Account();
        updateAccount.setUsername(account.getUsername());
        updateAccount.setPassword(account.getPassword());
        updateAccount.setCreatedAt(account.getCreatedAt());
        updateAccount.setIsActive(account.getIsActive());
        updateAccount.setEmail(account.getEmail());
        return ResponseEntity.ok(accountRepository.save(updateAccount));
    }

    public void delete(AccountDTO accountDTO){
        Account account = this.modelMapper.map(accountDTO, Account.class);
        accountRepository.delete(account);
    }

    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }


}
