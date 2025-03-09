package com.app.crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	InMemoryUserDetailsManager userDetailsManager() {
		UserDetails pratik = User.builder().username("pratik").password("{noop}pratik@123").roles("EMPLOYEE").build();
		UserDetails ronak = User.builder().username("ronak").password("{noop}ronak@123").roles("EMPLOYEE","MANAGER").build();
		UserDetails kamlesh = User.builder().username("kamlesh").password("{noop}kamlesh1@23").roles("EMPLOYEE","MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(pratik, ronak, kamlesh);
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer

				.requestMatchers(HttpMethod.GET, "/employewithroles").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/employewithroles/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/employewithroles").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/employewithroles").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/employewithroles/**").hasRole("ADMIN"));

		http.httpBasic(Customizer.withDefaults());

		http.csrf(csrf -> csrf.disable());
		return http.build();

	}
}
