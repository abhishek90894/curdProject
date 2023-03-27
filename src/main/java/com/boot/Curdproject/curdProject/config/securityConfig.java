package com.boot.Curdproject.curdProject.config;

import com.boot.Curdproject.curdProject.entities.user;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class securityConfig
{
    @Bean
    public UserDetailsService userDetailsService()
    {
//      UserDetails normal = user.builder().userName("abhishek")
//                .Password("12345")
//                .build();
//
//
//
//                return new InMemoryUserDetailsManager();
//
    }
}
