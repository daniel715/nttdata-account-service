package com.nttdata.nttdatab48accountservice.model.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

	private String _id;
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private String password;
    private String createdAt;
    private String address;
    private String city;
    private String country;
    private String telephone;
    private String clientType; // si es personal o empresarial
}
