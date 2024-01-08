package com.example.demo.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	public DataSource datasource;
	
	//This authentication manager will verify the username and password is correct or not and the role is matching or not.
	@Autowired
	public void authManager(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select username,password,enable from users where username=?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
		
	}
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((req) ->(req)
		.requestMatchers("/").permitAll()
		.requestMatchers("/admin").hasRole("ADMIN")
		.requestMatchers("/admin").hasAnyRole("ADMIN", "USER")
		.anyRequest().authenticated()
		);  //we can write //.formLogin();
		
		return http.build();
		
		
	}

}
