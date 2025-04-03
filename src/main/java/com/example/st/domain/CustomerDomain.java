package com.example.st.domain;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.example.st.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Configurable( autowire=Autowire.BY_TYPE)
public class CustomerDomain {
	
	@Autowired
	private CustomerService contractChangeService;
	
	public void test() {
		log.debug("test");
	}
	public void ctest(Customer tbCstCust) {
		
	}
	
}
