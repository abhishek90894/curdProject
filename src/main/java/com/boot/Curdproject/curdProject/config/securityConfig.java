package com.boot.Curdproject.curdProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class securityConfig
{
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
         daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
         return authenticationProvider();
    }
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        /**
//     UserDetails normal = User.builder().username("abhishek")
//             .password(passwordEncoder().encode("12345"))
//             .roles("NORMAL")
//             .build();
//     UserDetails admin = User.builder().username("ankur")
//             .password(passwordEncoder().encode("12345"))
//             .roles("ADMIN")
//             .build();
//              return new InMemoryUserDetailsManager(normal,admin);
//         */
//
//         return null;
//    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
}
