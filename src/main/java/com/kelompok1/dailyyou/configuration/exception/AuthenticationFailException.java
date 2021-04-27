package com.kelompok1.dailyyou.configuration.exception;

public class AuthenticationFailException extends IllegalArgumentException{
    public AuthenticationFailException(String msg) {
        super(msg);
    }
}
