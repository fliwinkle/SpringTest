package com.example.st.util;

import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UuidUtil implements IdentifierGenerator{

	@Override
	public String generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		UUID uuid =  UUID.randomUUID(); 
		// TODO Auto-generated method stub
		return uuid.toString();
	}
	
	
}
