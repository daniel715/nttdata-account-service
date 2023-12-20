package com.nttdata.nttdatab48accountservice.business.service;

import com.nttdata.nttdatab48accountservice.model.Account;
import com.nttdata.nttdatab48accountservice.model.api.CreateAccountRequest;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface IBusinessService {
//    Single<CreateAccountRequest> createAccount(Single<CreateAccountRequest> createAccountRequest);
Observable<Account> createAccount(Single<CreateAccountRequest> account);

}
