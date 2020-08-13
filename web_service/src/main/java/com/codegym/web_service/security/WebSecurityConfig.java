package com.codegym.web_service.security;

import com.codegym.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired(required = false)
    AccountServiceImpl userDetailService;
    @Autowired
    JwtRequestFilter jwtRequestFilter;
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**","/listProducts","/brand","/product","/account/create","/customers/","/createMemberAccount").permitAll().and().
//                authorizeRequests().antMatchers("/admin").permitAll().and().
                authorizeRequests().antMatchers("/admin","/api/admin/*","/account/update/*","/account/*").access("hasRole('ROLE_ADMIN')").and().
//                authorizeRequests().antMatchers("/admin").access("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')").and().
                authorizeRequests().antMatchers("/customers","/user-manage","/user-order","/customer-account/*").access("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')").and().
                authorizeRequests().antMatchers("/warehouse").access("hasAnyRole('ROLE_WAREHOUSE','ROLE_ADMIN')").and().
                authorizeRequests().antMatchers("/partner").access("hasAnyRole('ROLE_PARTNER','ROLE_ADMIN')").
                anyRequest().authenticated()
                .and().cors();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

