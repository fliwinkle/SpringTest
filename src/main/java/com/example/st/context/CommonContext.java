package com.example.st.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonContext {
	// 글로벌 아이디
	private String traceId; 
	// 사용자 아이디
	private String userId;
	// 유입 채널 정보
	private String channel;

}
