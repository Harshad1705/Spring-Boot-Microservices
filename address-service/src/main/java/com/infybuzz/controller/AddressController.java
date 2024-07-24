package com.infybuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.request.CreateAddressRequest;
import com.infybuzz.response.AddressResponse;
import com.infybuzz.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/create")
	public AddressResponse createStudent (@RequestBody CreateAddressRequest createAddressRequest) {
		return addressService.createStudent(createAddressRequest);
	}
	
	@GetMapping("/getById/{id}")
	public AddressResponse getById (@PathVariable long id) {
		return addressService.getById(id);
	}
	
}
