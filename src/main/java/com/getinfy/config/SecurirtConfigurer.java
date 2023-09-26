package com.getinfy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.getinfy.service.MyUserDetailsService;

@Configuration
public class SecurirtConfigurer {
	
	

	@Autowired
	private MyUserDetailsService userdetailsService;

	@Autowired
	public void conigurerUsers(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userdetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());

	}
	// configure in memory credentials

	/*
	 * @Bean public InMemoryUserDetailsManager configurerUsers() {
	 * 
	 * 
	 * UserDetails adminUser=org.springframework.security.core.userdetails.User.
	 * withDefaultPasswordEncoder() .username("venkat") .password("venkat@123")
	 * .authorities("ADMIN").build(); UserDetails
	 * normalUser=org.springframework.security.core.userdetails.User.
	 * withDefaultPasswordEncoder() .username("raja") .password("raja@123")
	 * .authorities("USER").build();
	 * 
	 * return new InMemoryUserDetailsManager(adminUser,normalUser); }
	 */

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((req) ->

		req.antMatchers("/contact").permitAll().anyRequest().authenticated()

		).formLogin();

		return http.build();

	}

}
