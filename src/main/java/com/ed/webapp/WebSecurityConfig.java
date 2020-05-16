package com.ed.webapp;

import com.ed.webapp.service.StaffUserDetailsService;
import com.ed.webapp.service.StudentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(3)
    public static class DefaultConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers("/", "/statistics", "/student/data", "/student/registration", "/js/statistics.js")
                .permitAll()
                .antMatchers("/module/edit/*", "/module/grades/*")
                .hasRole("Staff")
                .antMatchers("/module/enroll**", "/module/unenroll**")
                .hasRole("Student")
                .anyRequest()
                .authenticated();
        }
    }

    @Configuration
    @Order(2)
    public static class StudentConfigurationAdapter extends WebSecurityConfigurerAdapter {
        public StudentConfigurationAdapter() {
            super();
        }

        @Autowired
        public void configure(AuthenticationManagerBuilder auth, StudentUserDetailsService studentUserDetailService) throws Exception {
            auth.userDetailsService(studentUserDetailService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.requestMatcher(new AntPathRequestMatcher("/student/*"))
                .authorizeRequests()
                .antMatchers("/student/*")
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

    @Configuration
    @Order(1)
    public static class StaffConfigurationAdapter extends WebSecurityConfigurerAdapter {
        public StaffConfigurationAdapter() {
            super();
        }

        @Autowired
        public void configure(AuthenticationManagerBuilder auth, StaffUserDetailsService staffUserDetailService) throws Exception {
            auth.userDetailsService(staffUserDetailService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.requestMatcher(new AntPathRequestMatcher("/staff/*"))
                .authorizeRequests()
                .antMatchers("/staff/*")
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

    @Component
    public static class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

        public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
            WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();

            System.out.println("Login failed: " + auth.getSessionId());
        }
    }
}
