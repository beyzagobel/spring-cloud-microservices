package com.beyzagobel.api;

import com.beyzagobel.dto.AccountDTO;
import com.beyzagobel.entity.Account;
import com.beyzagobel.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class AccountApi {

    private final AccountService accountService;

    // get account rest api
    @GetMapping("accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") String id){
        return accountService.getAccount(id);
    }

    // create account rest api
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO){
        return accountService.createAccount(accountDTO);
    }

    // update account service
    @PutMapping("accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") String id ,@RequestBody AccountDTO accountDTO){
        return accountService.updateAccount(id,accountDTO);
    }

    // delete account rest api
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable("id") String id){
        return accountService.deleteAccount(id);
    }

    // get all account rest api
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(){
        return accountService.getAccounts();
    }


}
