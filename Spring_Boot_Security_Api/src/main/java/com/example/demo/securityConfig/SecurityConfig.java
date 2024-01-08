package com.example.demo.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests((request)-> request
//				.antMatchers("/","/login","/about").permitAll().anyRequest().authenticated()).formLogin();
//		return http.build();
//	}
	
//	@Bean
//	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
//		
//		http.authorizeRequests((request) -> request
//				.antMatchers("/","/login","/about", "/swagger-ui.html").permitAll()
//		
//				.anyRequest().authenticated()
//		).formLogin();
//		
//		return http.build();
//	}
	
//	  @Bean
//	    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
//	        http.authorizeRequests((request) -> request
//	                .antMatchers("/", "/login", "/about", "/swagger-ui.html").permitAll()
//	                .anyRequest().authenticated()
//	            )
//	            .formLogin();
//
//	        return http.build();
//	    }
	
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/", "/login", "/about", "/swagger-ui.html").permitAll()
				.anyRequest().authenticated()
			).formLogin();
	        // ...

		return http.build();
	}
}

//see the tutorial from following link -> https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
