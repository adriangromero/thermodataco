package com.instaply.thermodataco.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ThermodatacoConfig extends WebSecurityConfigurerAdapter {

    /**
     * Creates user and roles for access control
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

    // Access control for endpoints with HTTP Basic auth
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	//HTTP Basic authentication
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/status").permitAll()
                .antMatchers(HttpMethod.GET, "/historicals").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/zones").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/temperatures").hasAnyRole("USER", "ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
	
}
