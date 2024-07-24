package com.infybuzz.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infybuzz.response.AddressResponse;



// call to address-service through api-gateway
@FeignClient(value="api-gateway")
public interface AddressFeignClient {

    @GetMapping("/address-service/api/address/getById/{id}")
    public AddressResponse getById(@PathVariable long id);

}

// call to address-service direct
// @FeignClient(value="address-service" ,
//         path = "/api/address")
// public interface AddressFeignClient {

//     @GetMapping("/getById/{id}")
//     public AddressResponse getById(@PathVariable long id);

// }
