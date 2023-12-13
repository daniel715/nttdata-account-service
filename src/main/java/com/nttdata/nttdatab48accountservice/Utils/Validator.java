package com.nttdata.nttdatab48accountservice.Utils;

import com.nttdata.nttdatab48accountservice.model.Account;
import com.nttdata.nttdatab48accountservice.model.api.CreateAccountRequest;
import io.reactivex.rxjava3.core.Single;

public class Validator {

    public Boolean validCreateAccountRequestData(Single<CreateAccountRequest> account) {
        return true;
    }
}
