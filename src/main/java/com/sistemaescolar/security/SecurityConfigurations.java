package com.sistemaescolar.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desativa CSRF
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sessão stateless
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()) // Permite todas as requisições sem autenticação
            .httpBasic(httpBasic -> httpBasic.disable()) // Desativa autenticação básica
            .formLogin(form -> form.disable()); // Desativa formulário de login

        return http.build();
    }
}