package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // The difference between 401 and 403 is 401 is unauthenticated whereas 403 is forbidden
    // 401 is when there is no authentication or your credentials doesn't match with any of the ones in DB
    // 403 is that you are logged in as you have valid credentials but you don't have the required permission 
    // to access the page

    @Bean
    InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                            .username("john")
                            .password("{noop}password")
                            .roles("EMPLOYEE")
                            .build();

        UserDetails zeke = User.builder()
                            .username("zeke")
                            .password("{noop}password123")
                            .roles("EMPLOYEE", "MANAGER")
                            .build();
         
        UserDetails sweety = User.builder()
                            .username("sweety")
                            .password("{noop}love")
                            .roles("EMPLOYEE", "MANAGER", "ADMIN")
                            .build();

        return new InMemoryUserDetailsManager(john, zeke, sweety);
    }

    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> 
        configurer 
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
                
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
