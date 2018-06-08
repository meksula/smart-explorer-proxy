package com.smartexplorer.configuration.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author
 * Karol Meksuła
 * 07-06-2018
 * */

public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/error**", "/doc/**", "/resources/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
