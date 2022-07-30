package com.cloudofgoods.userservice.configaration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


@Configuration
public class OAuth2ServerConfiguration {

    static final String[] AUTH_WHITELIST = {
                    "/registration/**",
                    "/authenticate",
                    "/swagger-resources/**",
                    "/swagger-ui/**",
                    "/v3/api-docs",
                    "/webjars/**",
                    "/services/customer/**",
                    "/services/profiles/**"

    };
    private static final String RESOURCE_ID = "payment";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers(AUTH_WHITELIST)
                    .permitAll().anyRequest()
                    .fullyAuthenticated();
        }
    }

    @Configuration
    @EnableAuthorizationServer
    //To create an Authorization Server and grant access tokens you need to use @EnableAuthorizationServer and provide
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
        private final PasswordEncoder passwordEncoder;
        private final DataSource dataSource;
        private final AuthenticationManager authenticationManager;

        public AuthorizationServerConfiguration(AuthenticationManager authenticationManager, DataSource dataSource, PasswordEncoder passwordEncoder) {
            this.authenticationManager = authenticationManager;
            this.dataSource = dataSource;
            this.passwordEncoder = passwordEncoder;
        }
        @Bean
        TokenStore jdbcTokenStore() {
            return new JdbcTokenStore(dataSource);
        }
    }

}