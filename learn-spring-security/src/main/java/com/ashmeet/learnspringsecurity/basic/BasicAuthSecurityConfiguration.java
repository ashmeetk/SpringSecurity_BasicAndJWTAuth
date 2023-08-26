package com.ashmeet.learnspringsecurity.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration 
//public class BasicAuthSecurityConfiguration {
//	
//	@Bean
//	@Order(SecurityProperties.BASIC_AUTH_ORDER)
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		
//		http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated());
//		
//		http.sessionManagement(
//					session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				);
//		
//		//http.formLogin(withDefaults());
//		
//		http.httpBasic(withDefaults());
//		
//		http.csrf().disable();
//		
//		http.headers().frameOptions().sameOrigin();
//		
//		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//		
//		return http.build();
//	}
//	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		
//		var user = User.withUsername("ashmeet")
//					   .password("dummy")
//					   .passwordEncoder(str -> passwordEncoder().encode(str))
//					   .roles("USER")
//					   .build();
//		
//		var admin = User.withUsername("admin")
//				   .password("dummy")
//				   .passwordEncoder(str -> passwordEncoder().encode(str))
//				   .roles("ADMIN", "USER")
//				   .build();
//		
//		var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//		jdbcUserDetailsManager.createUser(user);
//		jdbcUserDetailsManager.createUser(admin);
//		return jdbcUserDetailsManager;
//		
//	}
//	
//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder()
//				.setType(EmbeddedDatabaseType.H2)
//				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//				.build();
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
