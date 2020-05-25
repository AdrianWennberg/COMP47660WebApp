package com.ed.webapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private  LoginAttemptService loginAttemptService;

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);



    public void onApplicationEvent(AuthenticationSuccessEvent e) {

        WebAuthenticationDetails auth = (WebAuthenticationDetails)
                e.getAuthentication().getDetails();

        loginAttemptService.loginSucceeded(auth.getRemoteAddress());
        logger.info("Login successful by IP " + auth.getRemoteAddress());

    }

}