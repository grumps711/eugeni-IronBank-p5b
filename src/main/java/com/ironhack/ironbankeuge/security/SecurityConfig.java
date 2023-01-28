package com.ironhack.ironbankeuge.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/user/admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/user/admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/user/admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/user/admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/user/accountholder/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/user/accountholder/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/user/accountholder/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/user/accountholder/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/account/checking/**").hasRole("ADMIN")

                .anyRequest()
                .authenticated()
                .and()
                .userDetailsService(jpaUserDetailsService)
                .httpBasic()
                .and()
                .build();
    }
}
