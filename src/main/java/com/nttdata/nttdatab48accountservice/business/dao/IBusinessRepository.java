package com.nttdata.nttdatab48accountservice.business.dao;

import com.nttdata.nttdatab48accountservice.model.api.Client;
import io.reactivex.rxjava3.core.Observable;

public interface IBusinessRepository {

    Observable createAccount();

    Observable<Client> findClientByDni(String dni);
}
