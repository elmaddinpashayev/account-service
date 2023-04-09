package com.haydikodlayalim.accountservice.controller;


import com.haydikodlayalim.accountservice.model.entity.Account;
import com.haydikodlayalim.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping
    public ResponseEntity<Account> update(@PathVariable("id") String id, @RequestBody Account account) {
        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping
    public void delete(@PathVariable("id") String id) {
        accountService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll(){
        System.out.println("Salam");
        return ResponseEntity.ok(accountService.findAll());
    }
}
