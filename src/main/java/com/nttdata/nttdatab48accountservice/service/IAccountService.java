package com.nttdata.nttdatab48accountservice.service;

import com.nttdata.nttdatab48accountservice.model.Account;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;


public interface IAccountService {

    Flowable<Account> list();

    Single<Account> save(Account account);

}
