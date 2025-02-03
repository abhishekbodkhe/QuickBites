//package com.app.project.main.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.app.project.main.filter.JwtAuthFilter;
//
//import jakarta.servlet.Filter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//	@Autowired
//	private JwtAuthFilter jwtAuthFilter;
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//		httpSecurity
//				.authorizeHttpRequests(
//						auth -> auth.requestMatchers("/api/restaurants").permitAll().anyRequest().authenticated())
//				.csrf(csrfConfig -> csrfConfig.disable())
//				.sessionManagement(sessionConfig -> sessionConfig
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.addFilterBefore((Filter) jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//				
////				.formLogin(Customizer.withDefaults());
//		return httpSecurity.build();
//	}
//
//}
