//package com.cloudofgoods.userservice.configaration.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private static String[] AUTH_WHITELIST = {
//            "/registration/**",
//            "/authenticate",
//            "/swagger-resources/**",
//            "/swagger-ui/**",
//            "/v3/api-docs",
//            "/webjars/**",
//
//    };
////    @Bean
////    protected AuthenticationManager getAuthenticationManager() throws Exception {
////        return super.authenticationManagerBean();
////    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return super.userDetailsService();
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().disable().authorizeRequests()
////                .antMatchers(AUTH_WHITELIST)
////                .permitAll();
//        http.authorizeRequests().anyRequest().permitAll();
//
//    }
//
////    @Bean
////    PasswordEncoder passwordEncoder() {
////        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
////    }
//
//}
