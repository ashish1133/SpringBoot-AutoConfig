package com.example.app.AutoConfig;

import org.apache.coyote.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

class AutoConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity Http)throws Exception{

        Http.csrf(Customizer->Customizer.disable());
        Http.authorizeHttpRequests(Request->Request.anyRequest().authenticated());
        Http.formLogin(Customizer.withDefaults());
        Http.httpBasic(Customizer.withDefaults());
        Http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return Http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("ashok")
                .password("ashok")
                .roles("user")
                .build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("smitha")
                .password("sm")
                .roles("House WIfe")
                .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }


}