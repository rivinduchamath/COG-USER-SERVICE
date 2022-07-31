package com.cloudofgoods.userservice.configaration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;



@Configuration
public class OAuth2ServerConfiguration extends ResourceServerConfigurerAdapter{

    private static final String[] AUTH_WHITELIST = {
            "/registration/**",
            "/authenticate",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/webjars/**",
            "/services/customer/**",
            "/services/**"


    };
    private static final String RESOURCE_ID = "payment";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll()
                //.access("hasAuthority('SCOPE_products.read')")
//                .anyRequest().authenticated()
//                .and()
//                .antMatchers(AUTH_WHITELIST)
//                .anyRequest()
//                .permitAll()
//                .anyRequest()
//                .authenticated()
        ;
//        http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll();
//        http.authorizeRequests().anyRequest().fullyAuthenticated();

    }

}