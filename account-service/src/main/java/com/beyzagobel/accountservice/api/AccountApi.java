package com.beyzagobel.accountservice.api;

import com.beyzagobel.accountservice.entity.Account;
import com.beyzagobel.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountApi {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return accountService.save(account);
    }

    @GetMapping("/{id}/update")
    public ResponseEntity<Account> update(@PathVariable("id") String id ,@RequestBody Account account){
        return accountService.update(id,account);
    }

    @DeleteMapping
    public void delete(@RequestBody Account account){
        accountService.delete(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll(){
        return accountService.getAll();
    }


}
