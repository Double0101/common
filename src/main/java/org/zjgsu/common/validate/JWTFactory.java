package org.zjgsu.common.validate;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JWTFactory {

    private static long ONE_WEEK = 604800000L;

    private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    private static byte[] SECRET_BYTES = DatatypeConverter.parseBase64Binary("org.zjgsu");

    private static Key SECRET_KEY = new SecretKeySpec(SECRET_BYTES, signatureAlgorithm.getJcaName());

    public static String generateToken(Map<String, Object> claims) {

        return Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + ONE_WEEK))
                .signWith(signatureAlgorithm, SECRET_KEY).compact();
    }

    public static Map parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody();
    }
}
