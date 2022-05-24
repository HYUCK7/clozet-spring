package kr.co.clozet.auth.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.co.clozet.auth.domains.Auth;
import kr.co.clozet.user.domains.Role;
import kr.co.clozet.auth.services.AuthDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// 디자인 패턴에 속하진 않지만, 외부 설정에 따라 다른 객체를 생성하는 패턴
@Log // 보안이 뚫릴 수도 있기 때문에, 승인 받는 것을 로그 찍는 것임. - CCTV 같은 기능
@Component
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private final AuthDetailsServiceImpl service;

    @Value("${security.jwt.token.security-key:secret-key}")
    private String securityKey;

    @Value("${security.jwt.token.expiration-length:3600000}")
    private long validityInMs = 3600000; // 1h

    @PostConstruct
    protected void init(){
        securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
        // 내부적으로 외부에 들어온 것을 인코딩해서, 키로 받음. (encoder, decoder)의 개념
        log.info("securityKey:"+securityKey);
    }

    public String createToken(String username, List<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority()))
                .filter(Objects::nonNull).collect(Collectors.toList()));
        Date now = new Date();
        Date validity = new Date(now.getTime()+validityInMs);
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity).signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }

    public Authentication getAuthenticate(String token){
        UserDetails auth = service.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(auth.getAuthorities(), "", auth.getAuthorities());
    }

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7);
        }
        return null;
    }
    public boolean validateToken(String token) throws Exception{
        try{
            Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException e){
            throw new Exception();
        }
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
