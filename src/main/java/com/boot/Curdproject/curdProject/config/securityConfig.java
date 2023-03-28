package com.boot.Curdproject.curdProject.config;

import com.boot.Curdproject.curdProject.entities.user;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class securityConfig
{
    @Bean
    public UserDetailsService userDetailsService()
    {
     UserDetails normal = User.builder().username("abhishek")
             .password(passwordEncoder().encode("12345"))
             .roles("NORMAL")
             .build();
     UserDetails admin = User.builder().username("ankur")
             .password(passwordEncoder().encode("12345"))
             .roles("ADMIN")
             .build();
              return new InMemoryUserDetailsManager(normal,admin);

    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
}
