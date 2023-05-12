package com.boot.Curdproject.curdProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//    {
//     http.authorizeHttpRequests()
//             .anyRequest()
//             .authenticated()
//             .and()
//             .formLogin()
//             .loginPage("login.html")
//             .loginProcessingUrl("/process-url")
//             .defaultSuccessUrl("/dashboard")
//             .failureUrl("error")
//             .and()
//             .logout()
//             .logoutUrl("/logout");
//
//         return http.build();
//    }
}
