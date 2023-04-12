package com.company.accountservice.service;

import com.company.accountservice.model.dto.AccountDto;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;


public interface AccountService {

   AccountDto get(String id);
   AccountDto save(AccountDto accountDto);
   AccountDto update(String id,AccountDto accountDto);
   void delete(String id);

   Slice<AccountDto> findAll(Pageable pageable);
}
