package com.ed.webapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

        /*
        public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
            WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();

            System.out.println("Login failed: " + auth.getSessionId());
        }
        */

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoginAttemptService loginAttemptService;

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);



    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        WebAuthenticationDetails auth = (WebAuthenticationDetails)
                e.getAuthentication().getDetails();

        loginAttemptService.loginFailed(auth.getRemoteAddress());
        logger.info("Login failed by IP " + auth.getRemoteAddress());

        /*
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();
        loginAttemptService.loginFailed(request.getRemoteAddr());
        //System.out.println("Login failed: " + request);
        System.out.println("Login failed: " + auth.getSessionId());

         */
    }
}