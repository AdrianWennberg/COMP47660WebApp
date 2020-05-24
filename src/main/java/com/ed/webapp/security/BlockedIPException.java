package com.ed.webapp.security;

public class BlockedIPException extends RuntimeException{

    public synchronized Throwable fillInStackTrace()  { return this; }

    public BlockedIPException(String errorMessage) {
        super(errorMessage);
    }
}
