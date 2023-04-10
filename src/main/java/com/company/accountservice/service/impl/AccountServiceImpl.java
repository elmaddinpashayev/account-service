package com.company.accountservice.service.impl;


import com.company.accountservice.model.entity.Account;
import com.company.accountservice.repository.AccountRepo;
import com.company.accountservice.service.AccountService;
import com.company.accountservice.model.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    private final ModelMapper modelMapper;

    @Override
    public AccountDto get(String id) {
        Account account = accountRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto,Account.class);
        AccountDto accountDto1 = modelMapper.map(accountRepo.save(account),AccountDto.class);
        return accountDto1;
    }

    @Override
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Account account = modelMapper.map(accountDto,Account.class);
        AccountDto resultAccountDto = modelMapper.map(accountRepo.save(account),AccountDto.class);
        return resultAccountDto;
    }

    @Override
    public void delete(String id) {
        Assert.isNull(id, "Id cannot be null");
        accountRepo.deleteById(id);
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepo.findAll().stream()
                .map(accountDto -> modelMapper.map(accountDto,AccountDto.class))
                .collect(Collectors.toList());
    }
}
