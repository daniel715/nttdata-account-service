package com.nttdata.nttdatab48accountservice.controller;

import com.nttdata.nttdatab48accountservice.model.Account;
import com.nttdata.nttdatab48accountservice.service.IAccountService;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    @RequestMapping(value ="/list" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flowable<Account> findProducts() {
        return iAccountService.list();
    }
}
