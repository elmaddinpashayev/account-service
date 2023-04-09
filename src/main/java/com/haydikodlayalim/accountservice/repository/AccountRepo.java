package com.haydikodlayalim.accountservice.repository;

import com.haydikodlayalim.accountservice.model.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepo extends CassandraRepository<Account,String> {

}
