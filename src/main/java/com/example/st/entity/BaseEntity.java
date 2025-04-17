package com.example.st.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.st.context.CommonContext;
import com.example.st.context.CommonContextHolder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Column(name = "INPP_CD", nullable = false)
	@LastModifiedDate
	@JsonIgnore //조회 불가 데이터 확인용
	private LocalDateTime inppCd;

	
	@Column(name = "INPP_USER")
	@JsonIgnore
    private String inppUser;

    public BaseEntity() {
    	CommonContext common = CommonContextHolder.get();
    	inppUser = common.getUserId();
    }

}
