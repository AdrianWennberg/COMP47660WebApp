package com.ed.webapp.security;

import com.ed.webapp.service.StudentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(2)
public class StudentConfigurationAdapter extends WebSecurityConfigurerAdapter {
    public StudentConfigurationAdapter() {
        super();
    }

    @Autowired
    private StudentUserDetailsService studentUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(studentUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/student/**")
            .authorizeRequests()
            .antMatchers("/student/registration", "/student/data")
            .permitAll()
            .antMatchers("/student/*", "/module/enroll", "/module/unenroll")
            .hasRole("Student")

            .and()
            .formLogin()
            .loginPage("/student/login")
            .loginProcessingUrl("/student/login")
            .defaultSuccessUrl("/student/profile")
            .permitAll()

            .and()
            .logout()
            .logoutUrl("/student/logout")
            .logoutSuccessUrl("/")
            .deleteCookies("JSESSIONID")

            .and()
            .csrf()
            .disable();
    }
}
