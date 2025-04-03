package com.example.st.entity;

import org.hibernate.annotations.UuidGenerator;

import com.example.st.util.ColumnEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity{
    @Id
    @UuidGenerator
    private String uuid;
    @Column(name = "cust_id", columnDefinition = "varchar(100)")
    private String custId;
    //비밀번호
    @Convert(converter = ColumnEncryptor.class)
    @Column(name = "password", columnDefinition = "varchar(100)")
    private String password;
    @Column(name = "rgno", columnDefinition = "varchar(30)")
    //주민등록번호
    private String rgno;
    
    
    //무분별한 setter 대신 개별 메소드 적용
    public void updatePassword(String rgno,String password) {
    	//rgno 검증
    	if(this.rgno.equals(rgno)) {
    		this.password = password;
    		//명시적 종료
    		return;
    	} else { //오류처리
    		
    	}
    }
    
    
    
    @Builder // 해당 클래스의 빌더 패턴 클래스 생성
	public Customer(String custId, String password, String rgno) {
		super();
		this.custId = custId;
		this.password = password;
		this.rgno = rgno;
	}
    
}
