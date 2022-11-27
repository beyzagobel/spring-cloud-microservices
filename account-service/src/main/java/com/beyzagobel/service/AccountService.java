package com.beyzagobel.service;

import com.beyzagobel.dto.AccountDTO;
import com.beyzagobel.entity.Account;
import com.beyzagobel.exception.ResourceNotFoundException;
import com.beyzagobel.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    public ResponseEntity<Account> getAccount(String id){
        return ResponseEntity.ok(accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not exist with id : " + id)));
    }

    public ResponseEntity<Account> createAccount(AccountDTO accountDTO){
        Account account = this.modelMapper.map(accountDTO, Account.class);
        return ResponseEntity.ok(accountRepository.save(account));
    }


    public ResponseEntity<Account> updateAccount(String id, AccountDTO accountDTO){
       Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not exist with id: " + id));
       Account accountUpdate = this.modelMapper.map(accountDTO, Account.class);

        account.setUsername(accountUpdate.getUsername());
        account.setPassword(accountUpdate.getPassword());
        account.setCreatedAt(accountUpdate.getCreatedAt());
        account.setIsActive(accountUpdate.getIsActive());
        account.setEmail(accountUpdate.getEmail());

        return ResponseEntity.ok(accountRepository.save(account));
    }

    public ResponseEntity<Map<String, Boolean>> deleteAccount(String id){
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not exist with id: " + id));
        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<Account>> getAccounts() {
        return ResponseEntity.ok(accountRepository.findAll());
    }


}
