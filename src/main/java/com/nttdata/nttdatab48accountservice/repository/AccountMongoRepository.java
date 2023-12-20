package com.nttdata.nttdatab48accountservice.repository;

import com.nttdata.nttdatab48accountservice.model.Account;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMongoRepository extends RxJava3CrudRepository<Account,String> {

//    @Query("{\"clientDni\" : \" " + clientId +"  \", \"productId\" : \"2\"}")
    @Query("{'clientDni': ?0, 'producId': ?0 }")
    Observable<Account> findByClientIdAndProducctId(String clientDni, String producId);
}
