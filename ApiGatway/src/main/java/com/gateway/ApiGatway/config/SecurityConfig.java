package com.gateway.ApiGatway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity)
    {
       return httpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(auth->
                    auth.pathMatchers("/public/**").permitAll()
                            .pathMatchers(HttpMethod.POST, "/auth/api/users/register").permitAll()
                            .pathMatchers("api/admin/**").hasRole("ADMIN").anyExchange().authenticated())

                .oauth2ResourceServer(oauth->oauth.jwt(Customizer.withDefaults())).build();
    }
}
