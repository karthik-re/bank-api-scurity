package org.example.bankapi.config;

import org.example.bankapi.filter.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.List;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();

        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/accounts/**",
                                        "/api/cards/**",
                                        "api/loans/**",
                                        "api/balance/**").authenticated()
//                                .requestMatchers("/api/auth/register").permitAll()
                                .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer
                        .configurationSource(request -> {
                            var cors = new CorsConfiguration();
                            cors.setAllowedOrigins(List.of("http://localhost:3000"));
                            cors.setAllowedMethods(Collections.singletonList("*"));
                            cors.setMaxAge(3600L);
                            cors.setAllowedHeaders(Collections.singletonList("*"));
                            return cors;
                        }))
                .csrf(csrf -> csrf
                        .csrfTokenRequestHandler(requestHandler)
                        .ignoringRequestMatchers("/api/auth/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                .securityContext(context -> context
                        .requireExplicitSave(false)
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                )
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
