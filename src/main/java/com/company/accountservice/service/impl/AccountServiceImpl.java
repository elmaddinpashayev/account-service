package com.company.accountservice.service.impl;


import com.company.accountservice.model.entity.Account;
import com.company.accountservice.repository.AccountRepo;
import com.company.accountservice.service.AccountService;
import com.company.accountservice.model.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        AccountDto accountDto1 = modelMapper.map(accountRepo.save(account), AccountDto.class);
        return accountDto1;
    }

    @Override
    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");

        Optional<Account> account = accountRepo.findById(id);
        Account accountDoUpdate = account.map(it -> {
            it.setBirthDate(accountDto.getBirthDate());
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            return it;
        }).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(accountRepo.save(accountDoUpdate), AccountDto.class);
    }

    @Transactional
    @Override
    public void delete(String id) {
        Account account = accountRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        accountRepo.delete(account);
    }
    @Override
    public Slice<AccountDto> findAll(Pageable pageable) {
        return null;
    }
}
