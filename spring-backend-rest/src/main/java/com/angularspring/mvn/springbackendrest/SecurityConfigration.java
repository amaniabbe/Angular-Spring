package com.angularspring.mvn.springbackendrest;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SecurityConfigration extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception{

        http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/auth", "/").permitAll()
        .anyRequest().authenticated()
        .and()
        .csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        ;
    }

    
    
    
       
    

}