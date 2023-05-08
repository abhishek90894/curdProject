package com.boot.Curdproject.curdProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfig {

    @Autowired
    private UserDetailsService userDetailsService;


//
//
//    @Bean
//    public UserDetailsService getUserDetailService()
//    {
//        UserDetails normal = User.builder()
//                .username("abhishek")
//                .password(passwordEncoder().encode("123456789"))
//                .roles("normal")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("raghav")
//                .password(passwordEncoder().encode("123456789"))
//                .roles("admin")
//                .build();
//        return  new InMemoryUserDetailsManager(normal,admin);
//    }
//
    @Bean
    public PasswordEncoder getpasswordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(getpasswordEncoder());
        return daoAuthenticationProvider;
    }
}
