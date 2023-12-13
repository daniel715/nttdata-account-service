package com.nttdata.nttdatab48accountservice.business.controller;

import com.nttdata.nttdatab48accountservice.business.service.IBusinessService;
import com.nttdata.nttdatab48accountservice.model.api.CreateAccountRequest;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/business")
public class BusinessController {

    @Autowired
    private IBusinessService iBusinessService;

    @PostMapping(value = "/save")
    public Observable<CreateAccountRequest> createAccount(@RequestBody CreateAccountRequest account) {
        return this.iBusinessService.createAccount(Single.just(account));
//        account.observeOn(Scheduler.).subscribeOn(AndroidScheduler.mainThread()).subscribe(createAccountRequestObserver);
//        return iBusinessService.createAccount();
    }


}
