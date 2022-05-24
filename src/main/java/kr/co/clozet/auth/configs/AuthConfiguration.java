package kr.co.clozet.auth.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*/**")
                .antMatchers("/");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // default인 csrf 보안이 뚫렸기 때문에,  사용하지 않음.-Base64 사용
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/users/join").permitAll() // 누구든 회원가입 가능
                .antMatchers("/users/login").permitAll()
                .anyRequest().authenticated(); // 나머지 요청은 인증을 받아라
        http.exceptionHandling().accessDeniedPage("/users/login"); // 회원가입 해야 우리 사이트는 사용 가능
    }
}
