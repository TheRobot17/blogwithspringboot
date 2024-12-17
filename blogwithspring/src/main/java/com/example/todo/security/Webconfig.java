package com.example.todo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class Webconfig {
	
	
	public static final String[] WHITELIST= {
			"/login",
			"/register",
			"/css/**",
			"/js/**",
			"/h2-console/**",
			"/images/**"
	};
	
	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		http 
		.authorizeRequests()
		.requestMatchers(WHITELIST)
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.usernameParameter("email")
		.passwordParameter("password")
		.permitAll()
		.defaultSuccessUrl("/" ,true)
		.failureUrl("/login?error")
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.and()
		.rememberMe().rememberMeParameter("remember-me")
		.and()
		.httpBasic();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return  http.build();
	
}

}
