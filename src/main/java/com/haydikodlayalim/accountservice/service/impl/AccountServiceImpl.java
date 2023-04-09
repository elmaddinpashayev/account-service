package com.haydikodlayalim.accountservice.service.impl;


import com.haydikodlayalim.accountservice.model.entity.Account;
import com.haydikodlayalim.accountservice.repository.AccountRepo;
import com.haydikodlayalim.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    @Override
    public Account get(String id) {
        return accountRepo.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Account save(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account update(String id, Account account) {
        Assert.isNull(id, "Id cannot be null");
        return accountRepo.save(account);
    }

    @Override
    public void delete(String id) {
        Assert.isNull(id, "Id cannot be null");
        accountRepo.deleteById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }
}
