package com.cloudfy.academyregistrationsystem.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/login/operator", HttpMethod.POST.name())).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/register/customer", HttpMethod.POST.name())).hasRole("OPERATOR")
                        .requestMatchers(new AntPathRequestMatcher("/update/customer/{id}", HttpMethod.PUT.name())).hasRole("OPERATOR")
                        .requestMatchers(new AntPathRequestMatcher("/delete/customer/{id}", HttpMethod.DELETE.name())).hasRole("OPERATOR")
                        .requestMatchers(new AntPathRequestMatcher("/customer/index", HttpMethod.GET.name())).hasRole("OPERATOR")
                        .requestMatchers(new AntPathRequestMatcher("/customer/{id}", HttpMethod.GET.name())).hasRole("OPERATOR")
                        .requestMatchers(new AntPathRequestMatcher("/operator/index", HttpMethod.GET.name())).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/delete/operator/{id}", HttpMethod.DELETE.name())).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/update/operator/{id}", HttpMethod.PUT.name())).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/operator/{id}", HttpMethod.GET.name())).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/register/operator", HttpMethod.POST.name())).permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}