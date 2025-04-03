package com.example.st.domain;

import java.util.Optional;

import com.example.st.dto.CustomerDto;
import com.example.st.entity.Customer;

public interface CustomerService {

	/**
	 * @param pk
	 * @return
	 * @throws Exception 
	 */
	Customer find(String pk) throws Exception;

	Customer create(CustomerDto input);

	Customer updatePassword(CustomerDto input) throws Exception;


}
