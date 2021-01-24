package com.follytech.bankaccount.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	/*
		auth.inMemoryAuthentication()
		.withUser("admin").password("1234").roles("ADMIN", "USER");
		
		auth.inMemoryAuthentication()
		.withUser("user").password("1234").roles("USER");
		
	*/
		 
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT username as principal, password as credentials, active FROM users WHERE username=?")
		.authoritiesByUsernameQuery("SELECT username as principal, roles as role FROM users_roles WHERE username=?")
		.rolePrefix("ROLE_")
		.passwordEncoder(new MessageDigestPasswordEncoder("MD5"));
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/operations", "/consulterCompte").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403"); 
	}

}
