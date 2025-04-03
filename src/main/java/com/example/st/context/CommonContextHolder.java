package com.example.st.context;

public class CommonContextHolder {
	private static final ThreadLocal<CommonContext> contextHolder = ThreadLocal.withInitial(() -> new CommonContext());
	
	public static CommonContext get() {
		// threadlocal get 함수에서 null인경우 빈 객체를 만들어서 리턴 - null처리 불필요
		return contextHolder.get();
	}
	public static void clear() {
		contextHolder.remove();
	}
	
}
