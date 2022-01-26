package com.webproject.zerosheet.security;

import com.webproject.zerosheet.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo){

        return username -> {
            var user = userRepo.findByUsername(username);

            if(user == null){
                throw new UsernameNotFoundException("User with username %s is not found!" + username);
            }

            return (UserDetails) user;
        };

    }

    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeRequests()
                .antMatchers( "/dashboard", "/inventory", "/products", "/sales",
                        "/purchases", "/vendors", "customers", "/addProd", "/addSales",
                        "/addPurch", "/addVendor", "/addCust"
                ).access("hasRole('SUPER') || hasRole('ADMIN') || hasRole('USER')")
                .antMatchers("/editProd", "/deleteProd", "/editVend", "/deleteVend",
                        "/editInv", "/editCust", "/editSales", "/editPurch", "/deleteSales", "/deletePurch")
                .hasRole("SUPER")
                .antMatchers("/", "/**").access("permitAll")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .build();
    }



}
