package com.ed.webapp.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BlockedIPException extends UsernameNotFoundException {

    public BlockedIPException(String errorMessage) {
        super(errorMessage);
    }
}
