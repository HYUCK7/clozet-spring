package kr.co.clozet.auth.domains;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log
public class AuthToken {
    private String token;
    private String key;

    public AuthToken(String key) {
        this.key = key;
        this.token = createToken();
    }

    private String createToken() {
        try {
            Map<String,  Object> headers = new HashMap<>();
            headers.put("typ", "jwt");
            headers.put("alg", "HS256");
            Map<String, Object> payload = new HashMap<>();
            headers.put("data","blahblah");
            Date exp = new Date();
            exp.setTime(exp.getTime() + 1000 * 60L * 20L); // 토큰 유효시간 설정
            headers.put("exp","");

            return Jwts.builder()
                    .setHeader(headers) // header
                    .setClaims(payload) // React Payload
                    .setSubject("user")// payload
                    .setExpiration(exp) // payload
                    .signWith(SignatureAlgorithm.HS256, key.getBytes(StandardCharsets.UTF_8)) // signature
                    .compact();
        }
        catch (SecurityException e){log.info("Security-Exception JWT");}
        catch (MalformedJwtException e){log.info("MalformedJwtException JWT" );}
        catch (ExpiredJwtException e){log.info("ExpiredJwtException JWT");}
        catch (UnsupportedJwtException e){log.info("UnsupportedJwtException JWT");}
        catch (IllegalAccessError e){log.info("IllegalAccessError JWT");}
        return null;
    }
}
