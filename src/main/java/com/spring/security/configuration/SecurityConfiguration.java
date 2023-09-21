package com.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	

	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
        .authorizeHttpRequests((authz) -> authz
        		.antMatchers("/public","/swagger-ui/*", "/swagger-resources/**", "/v3/api-docs", "/webjars/**").permitAll()
        		.antMatchers("/user").hasRole("USER")
        		.antMatchers("/admin").hasRole("ADMIN")
        		.anyRequest().authenticated()
        ).formLogin();
		
	    return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("suraj")
				.password("suraj")
				.roles("USER")
				.build();
		
		UserDetails admin = User.withUsername("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
