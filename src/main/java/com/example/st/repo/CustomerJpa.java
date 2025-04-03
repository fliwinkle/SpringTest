package com.example.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.st.entity.Customer;

public interface CustomerJpa extends JpaRepository<Customer,String>{
	
}
