package com.dh.Clinica;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/odontologos.html").hasRole("USER")
                .antMatchers("/pacientes.html").hasRole("USER")
                .antMatchers("/turno.html").hasRole("USER")
                .antMatchers("/alta-odontologos.html").hasRole("ADMIN")
                .antMatchers("/alta-pacientes.html").hasRole("ADMIN")
                .antMatchers("/alta-turno.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout();
    }
}
