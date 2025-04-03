package com.example.st.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CustomerDto {
    private String uuid;

    private String custId;

    private String password;
    
    private String rgno;

    @Builder
    public CustomerDto(String uuid, String custId, String password, String rgno) {
		super();
		this.uuid = uuid;
		this.custId = custId;
		this.password = password;
		this.rgno = rgno;
	}
}
