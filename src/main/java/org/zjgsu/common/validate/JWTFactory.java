package org.zjgsu.common.validate;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWTFactory {

    private static long ONE_WEEK = 604800000L;
    private static String SIGN_KEY = "org.zjgsu";

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + ONE_WEEK))
                .signWith(SignatureAlgorithm.ES256, SIGN_KEY).compact();
    }

    public static Map parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(String.valueOf(SignatureAlgorithm.ES256))
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
