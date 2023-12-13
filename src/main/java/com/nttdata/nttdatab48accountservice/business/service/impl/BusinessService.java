package com.nttdata.nttdatab48accountservice.business.service.impl;

import com.nttdata.nttdatab48accountservice.Utils.Validator;
import com.nttdata.nttdatab48accountservice.business.dao.IBusinessRepository;
import com.nttdata.nttdatab48accountservice.business.dao.impl.BusinessRepository;
import com.nttdata.nttdatab48accountservice.business.service.IBusinessService;
import com.nttdata.nttdatab48accountservice.model.Account;
import com.nttdata.nttdatab48accountservice.model.api.Client;
import com.nttdata.nttdatab48accountservice.model.api.CreateAccountRequest;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class BusinessService implements IBusinessService {


    @Autowired
    IBusinessRepository businessRepository;
    Validator validator = new Validator();

    @Override
    public Observable<CreateAccountRequest> createAccount(Single<CreateAccountRequest> createAccountRequest) {

        final CreateAccountRequest[] request = {new CreateAccountRequest()};
        CreateAccountRequest account;
        //guardando el request
        createAccountRequest.subscribe(ele -> request[0] = ele);
        account = request[0];

        // validando que data sea no nula
        validator.validCreateAccountRequestData(Single.just(account));

        // validar si dni existe en bd
        Observable<Client> response = businessRepository.findClientByDni(account.getDni());
        System.out.println("********** response "+response.subscribe(res ->  ));
//        var newAccount = Account.builder()
//                    .clientId(temporarylientId)
//                    .productId(account.getProductId())
//                    .balance(BigDecimal.valueOf(0))
//                    .currency("soles")
//                    .accountNumber("4887252313697715")
//                    .build();
        return null;
    }


}
