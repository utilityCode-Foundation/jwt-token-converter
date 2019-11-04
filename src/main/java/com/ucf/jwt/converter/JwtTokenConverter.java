package com.ucf.jwt.converter;

import java.util.Map;

import io.jsonwebtoken.Claims;

public interface JwtTokenConverter {

	public String createJWT(String id, Object issuer, String subject, Map<String, Object> claim, long ttlMillis,
			String secret);

	public Claims decodeJWT(String jwt, String secret);


}
