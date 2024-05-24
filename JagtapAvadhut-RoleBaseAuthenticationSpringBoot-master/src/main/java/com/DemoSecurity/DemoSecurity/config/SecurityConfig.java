package com.DemoSecurity.DemoSecurity.config;

import com.DemoSecurity.DemoSecurity.security.JwtAuthenticationEntryPoint;
import com.DemoSecurity.DemoSecurity.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;


    private static final String[] SubAdminCall = {
            "/emp-management/new-emp-create"
    };
    private static final String[] AdminCall = {
            "/emp-management/get-all-emp",
            "/emp-management/produce",
            "/emp-management/consume",
            "/home/users"
    };
    private static final String[] GuestCall = {
            "/auth/login",
            "/auth/signup",
            "/auth/logout",
            "/",
            "/csrf",
            "/swagger-ui.html/**",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-resources/**",
            "/v3/api-docs/**",
            "swagger-resources"
    };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/test").authenticated()
                .requestMatchers(GuestCall).permitAll()
                .requestMatchers(AdminCall).hasAuthority("ADMIN")
                .requestMatchers(SubAdminCall).hasAuthority("SUBADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}