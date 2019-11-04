package com.ucf.jwt.converter.impl;

import java.util.Date;
import java.util.Map;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import javax.xml.bind.DatatypeConverter;
import com.ucf.jwt.converter.JwtTokenConverter;

public class JwtTokenConverterImpl implements JwtTokenConverter {

	public String createJWT(String id, Object issuer, String subject, Map<String, Object> claim, long ttlMillis,
			String secret) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        String builder = Jwts.builder().setId(id)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(subject)
                .setIssuer(issuer.toString())
                .setExpiration(new Date(System.currentTimeMillis() + ttlMillis))
                .signWith(signingKey).compact();
        return builder;
    
	}

	public Claims decodeJWT(String jwt, String secret) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(jwt)
				.getBody();
		return claims;
	}

	
}