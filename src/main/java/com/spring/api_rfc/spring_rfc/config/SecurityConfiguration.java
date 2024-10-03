package com.spring.api_rfc.spring_rfc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilterOld jwtAuthenticationFilterOld;

    public SecurityConfiguration(
            JwtAuthenticationFilterOld jwtAuthenticationFilterOld,
            AuthenticationProvider authenticationProvider
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilterOld = jwtAuthenticationFilterOld;
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//            .disable()
//            .authorizeHttpRequests()
//            .requestMatchers("/auth/**")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authenticationProvider(authenticationProvider)
//            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http.csrf(csrf -> csrf.disable())  // Disabling CSRF with the new API
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/login").permitAll()
                    .requestMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html",
                            "/webjars/**") // protect open api docs with basic auth
                    .authenticated()
                    .anyRequest().authenticated()         // Require authentication for other requests
            )
            .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions
            )
            .authenticationProvider(authenticationProvider) // Set your custom AuthenticationProvider
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class).httpBasic(withDefaults()); // Add JWT filter
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:8080"));
        configuration.setAllowedMethods(List.of("GET", "POST"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
