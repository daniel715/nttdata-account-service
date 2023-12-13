package com.nttdata.nttdatab48accountservice.repository;

import com.nttdata.nttdatab48accountservice.model.Account;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMongoRepository extends RxJava3CrudRepository<Account,String> {
}
