package com.example.st.domain;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.st.dto.CustomerDto;
import com.example.st.entity.Customer;
import com.example.st.repo.CustomerJpa;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerJpa customerJpa;
	
	@Override
	public Customer find(String uuid) throws Exception {
		Optional<Customer> optCustomer = customerJpa.findById(uuid);
		if(optCustomer.isEmpty()) { // uuid 미존재시 오류처리
			throw new Exception();
		} else {
		return optCustomer.get();
		}
	}
	@Transactional
	@Override
	public Customer create(CustomerDto input) {
		String custId = input.getCustId();
		String password = input.getPassword();
		String rgno = input.getRgno();
		
		Customer customer = Customer.builder().custId(custId).password(password).rgno(rgno).build();
		
		return customerJpa.save(customer);
		
	}
	@Transactional
	@Override
	public Customer updatePassword(CustomerDto input) throws Exception {
		String uuid = input.getUuid();
		String password = input.getPassword();
		String rgno = input.getRgno();
		
		Customer customer = find(uuid);
		customer.updatePassword(rgno, password);
		//조회 실패시 에러처리 
		return customerJpa.save(customer);
		
	}
}
