package com.example.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class AppConfig {

    @Bean
    public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
        http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors ->{
                    cors.configurationSource(new CorsConfigurationSource() {
                        @Override
                        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                            CorsConfiguration cfg= new CorsConfiguration();
                            cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
                            cfg.setAllowedMethods(Collections.singletonList("*"));
                            cfg.setAllowCredentials(true);
                            cfg.setAllowedHeaders(Collections.singletonList("*"));
                            cfg.setExposedHeaders(Arrays.asList("Authorization"));
                            return cfg;
                        }
                    });
                })
                .authorizeHttpRequests(auth ->{
                    auth
                            .requestMatchers(HttpMethod.GET,"/welcome").permitAll()
                            .requestMatchers(HttpMethod.POST,"/bdo/project", "/bdo/gpm", "/bdo/assignProject").permitAll()
                            .requestMatchers(HttpMethod.GET,"/bdo/projects", "/bdo/gpms", "/bdo/workers", "/bdo/gpm/{gpmID}/workers", "/bdo/project/{projectID}/workers").permitAll()
                            .requestMatchers(HttpMethod.POST,"gpm/{gpmID}/worker/register", "/gpm/assignProject").hasRole("GPM")
                            .requestMatchers(HttpMethod.GET, "/gpm/{gpmID}/projects", "/gpm/{gpmID}/workers", "/gpm/workers/{aadhaar}", "/gpm/worker/{workerID}/workingDaysAndWages").hasRole("GPM")
                            .requestMatchers(HttpMethod.PUT, "/gpm/{gpmID}/worker/{workerID}").hasRole("GPM")
                            .requestMatchers(HttpMethod.DELETE, "/gpm/{gpmID}/worker/{workerID}").hasRole("GPM")
                            .requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
                            .anyRequest().authenticated();
                })
                .csrf(csrf -> csrf.disable())
                .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
