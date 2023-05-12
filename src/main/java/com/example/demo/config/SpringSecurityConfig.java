package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
   @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userDetails= User.withDefaultPasswordEncoder()
                .username("rose")
                .password("123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
               .authorizeHttpRequests((authz)->authz
                       .requestMatchers("/message","/**")
                       .authenticated()
               )
               .httpBasic();
       return http.build();

    }
}
