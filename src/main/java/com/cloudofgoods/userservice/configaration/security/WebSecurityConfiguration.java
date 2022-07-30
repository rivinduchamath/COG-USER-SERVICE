package com.cloudofgoods.userservice.configaration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    protected AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
    private static final String[] AUTH_WHITELIST = {
            "/authenticate",
            "/services/customer",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/webjars/**",
            "/services/customer/**",
            "/services/profiles/**"

    };

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    /*    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers();
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().disable().authorizeRequests()
                .antMatchers(AUTH_WHITELIST)
                .permitAll();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
