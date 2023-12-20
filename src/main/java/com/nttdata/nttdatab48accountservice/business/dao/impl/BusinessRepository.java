package com.nttdata.nttdatab48accountservice.business.dao.impl;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.nttdata.nttdatab48accountservice.business.dao.IBusinessRepository;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class BusinessRepository implements IBusinessRepository {

    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("CLIENT-SERVICE", false);
        return instance.getHomePageUrl();
    }


    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Observable findClientByDni(String dni) {

        String url = this.serviceUrl() +"/api/v1/clients/find/" + dni;
        String json = new String();
        return Observable.fromCallable(() -> callExternalUrl(url, json, HttpMethod.GET))
                .subscribeOn(Schedulers.io())
                .doOnError( e -> {
                    System.out.println("error *****  " + e );
                })
                .flatMap(re -> {
                            if (re.hasBody()) {
                                return Observable.just(re.getBody());
                            } else {
                                System.out.println("en else");
                                return Observable.error(new RuntimeException("Bad response status " + re.getStatusCode()));
                            }
                        }
                ) // I need explicit cast or it won't compile :-(
                .observeOn(Schedulers.computation());
    }

    @Override
    public Observable createAccount() {
        String url = "http://localhost:8083/api/v1/clients/find/6573e196e42ce44a3a8b2ede";
        String json = new String();
        return Observable.fromCallable(() -> callExternalUrl(url, json, HttpMethod.GET))
                .subscribeOn(Schedulers.io())
                .flatMap(re -> {
                            if (re.hasBody()) {
                                return Observable.just(re.getBody());
                            } else
                                return Observable.error(new RuntimeException("Bad response status " + re.getStatusCode()));
                        }
                ) // I need explicit cast or it won't compile :-(
                .observeOn(Schedulers.computation());
    }

    private ResponseEntity<String> callExternalUrl(String url, String json, HttpMethod method) {
        HttpEntity request;
        request = new HttpEntity(json);
        return restTemplate.exchange(url, method, request, String.class);
    }
}
