package com.ed.webapp.security;

import com.ed.webapp.service.StaffUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(1)
public class StaffConfigurationAdapter extends WebSecurityConfigurerAdapter {
    public StaffConfigurationAdapter() {
        super();
    }

    @Autowired
    private StaffUserDetailsService staffUserDetailService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(staffUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/staff/**")
            .authorizeRequests()
            .antMatchers("/staff/*", "/module/edit/*", "/module/grades/*")
            .hasRole("Staff")

            .and()
            .formLogin()
            .loginPage("/staff/login")
            .loginProcessingUrl("/staff/login")
            .defaultSuccessUrl("/staff/profile")
            .permitAll()

            .and()
            .logout()
            .logoutUrl("/staff/logout")
            .logoutSuccessUrl("/")
            .deleteCookies("JSESSIONID")

            .and()
            .csrf()
            .disable();
    }
}
