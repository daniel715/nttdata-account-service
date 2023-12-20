package com.nttdata.nttdatab48accountservice.service.impl;


import com.nttdata.nttdatab48accountservice.model.Account;
import com.nttdata.nttdatab48accountservice.repository.AccountMongoRepository;
import com.nttdata.nttdatab48accountservice.service.IAccountService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountMongoRepository accountMongoRepository;


    @Override
    public Flowable<Account> list() {
        return accountMongoRepository.findAll();
    }

    @Override
    public Single<Account> save(Account account) {
        return accountMongoRepository.save(account);
    }

    @Override
    public Observable<Account> findByclientIdandProductId(String clientId, String producId) {
        return accountMongoRepository.findByClientIdAndProducctId(clientId, producId);
    }
}
