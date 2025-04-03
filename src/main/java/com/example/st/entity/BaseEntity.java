package com.example.st.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.st.context.CommonContext;
import com.example.st.context.CommonContextHolder;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Column(name = "INPP_CD", nullable = false)
	@LastModifiedDate
	private LocalDateTime inppCd;

	@Column(name = "INPP_USER")
    private String inppUser;

    public BaseEntity() {
    	CommonContext common = CommonContextHolder.get();
    	inppUser = common.getUserId();
    }

}
