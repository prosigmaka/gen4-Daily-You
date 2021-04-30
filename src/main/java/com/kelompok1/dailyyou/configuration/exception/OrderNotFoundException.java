package com.kelompok1.dailyyou.configuration.exception;

public class OrderNotFoundException extends IllegalArgumentException {
    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
