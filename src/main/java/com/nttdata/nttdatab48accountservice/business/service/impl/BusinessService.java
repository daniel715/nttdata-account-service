package com.nttdata.nttdatab48accountservice.business.service.impl;

import com.netflix.discovery.converters.Auto;
import com.nttdata.nttdatab48accountservice.Utils.Validator;
import com.nttdata.nttdatab48accountservice.business.dao.IBusinessRepository;
import com.nttdata.nttdatab48accountservice.business.dao.impl.BusinessRepository;
import com.nttdata.nttdatab48accountservice.business.service.IBusinessService;
import com.nttdata.nttdatab48accountservice.model.Account;
import com.nttdata.nttdatab48accountservice.model.api.Client;
import com.nttdata.nttdatab48accountservice.model.api.CreateAccountRequest;
import com.nttdata.nttdatab48accountservice.repository.AccountMongoRepository;
import com.nttdata.nttdatab48accountservice.service.IAccountService;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;


@Service
public class BusinessService implements IBusinessService {


    @Autowired
    IAccountService iAccountService;

    @Autowired
    AccountMongoRepository accountMongoRepository;
    Validator validator = new Validator();

    @Override
    public Observable<Account> createAccount(Single<CreateAccountRequest> createAccountRequest) {

        final Client[] client = {new Client()};
        final CreateAccountRequest[] request = {new CreateAccountRequest()};
        CreateAccountRequest account;

        //guardando el request
        createAccountRequest.subscribe(ele -> request[0] = ele);
        account = request[0];

        // validando que data sea no nula
        validator.validCreateAccountRequestData(Single.just(account));
//consultar a la base de datos las cuentas del cliente de tipo personal
        if (account.getClientType().equals("personal")) {
            System.out.println("Dentro de if personal");
            final Account[] respuesta = {new Account()};
            Observable<Account> response = accountMongoRepository.findByClientIdAndProducctId(account.getDni(), account.getProductId());
            response.subscribe(e -> respuesta[0] = e );
            System.out.println("Respuesta ***** " + respuesta[0]);
        }

//        Observable<Client> response = businessRepository.findClientByDni(account.getDni());
//        response.subscribe(res -> client[0] = res);

        var newAccount = Account.builder()
                .clientDni(account.getDni())
                .productId(account.getProductId())
                .balance(BigDecimal.valueOf(0))
                .currency(account.getAccountCurrency())
                .accountNumber(String.valueOf(new Random().nextInt(900000) + 100000))
                .build();
        return iAccountService.save(newAccount).toObservable();
    }


}
