package com.ssafy.vue.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface JwtService {

	<T> String create(String key, T data, String subject);
	Map<String, Object> get(String key);
	String getUserId();
    public String getUserIdByToken(String token) throws UnsupportedEncodingException;
	boolean isUsable(String jwt);
	
}
