package com.infybuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.feignClients.AddressFeignClient;
import com.infybuzz.response.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);

    long count = 1;

    @Autowired
	AddressFeignClient addressFeignClient;

    @CircuitBreaker(name = "addressService" , fallbackMethod ="fallbackGetAddressById" )
    public AddressResponse getAddressById(long addressId) {

        
        logger.info("Count = " + count);
        count++;

		// use feign client
		AddressResponse addressResponse = addressFeignClient.getById(addressId);
		return addressResponse;

		// use web client
		// Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/" + addressId).retrieve()
		// 		.bodyToMono(AddressResponse.class);

		// return addressResponse.block();  
	}

    public AddressResponse fallbackGetAddressById(long addressId, Throwable th) {
        logger.error("Error = " + th);
		return new AddressResponse();  
	}

}
