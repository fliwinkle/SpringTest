package com.example.st.controller;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.st.domain.CustomerService;
import com.example.st.dto.CustomerDto;
import com.example.st.entity.Customer;
import com.example.st.util.JasyptConfigAES;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/customer")
@Slf4j
@Tag(name = "customer", description = "고객 API")
public class CustomerController {
	
	private final CustomerService customerService;

	
	@GetMapping(path = "/{uuid}")
	public ResponseEntity<Customer> find(@PathVariable(name = "uuid") String uuid) throws Exception {
		Customer value = customerService.find(uuid);
		return new ResponseEntity<Customer>(value, HttpStatusCode.valueOf(200));
		
	}
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody CustomerDto input) {
		Customer value = customerService.create(input);
		return new ResponseEntity<Customer>(value, HttpStatusCode.valueOf(200));
	}
	
	@PutMapping(path = "update-pw")
	public ResponseEntity<Customer> updatePassword(@RequestBody CustomerDto input) throws Exception {
		Customer value = customerService.updatePassword(input);
		return new ResponseEntity<Customer>(value, HttpStatusCode.valueOf(200));
	}
	
}
