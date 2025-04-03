package com.example.st.controller;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.st.domain.CustomerServiceImpl;
import com.example.st.dto.CustomerDto;
import com.example.st.entity.Customer;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequiredArgsConstructor
@RequestMapping
@Slf4j
@Tag(name = "contractChange", description = "계약변경 API")
public class CustomerController {
	
	private final CustomerServiceImpl customerService;

	
	@PostMapping(path = "/v1/customer/find")
	public ResponseEntity<Customer> find(String uuid) throws Exception {
		Customer value = customerService.find(uuid);
		return new ResponseEntity<Customer>(value, HttpStatusCode.valueOf(200));
	}
	
	@PostMapping(path = "/v1/customer/create")
	public ResponseEntity<Customer> create(@RequestBody CustomerDto input ) {
		Customer value = customerService.create(input);
		return new ResponseEntity<Customer>(value, HttpStatusCode.valueOf(200));
	}
	
	@PostMapping(path = "/v1/customer/update")
	public ResponseEntity<Customer> updatePassword(@RequestBody CustomerDto input ) throws Exception {
		Customer value = customerService.updatePassword(input);
		return new ResponseEntity<Customer>(value, HttpStatusCode.valueOf(200));
	}
	
}
