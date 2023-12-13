package com.nttdata.nttdatab48accountservice.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {
    private String dni;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String address;
    private String city;
    private String country;
    private String telephone;
    private String clientType; // si es personal o empresarial
    private String accountCurrency;
    private String productId;

}