package com.fiap.exercicio.core.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(final String message) {
        super(message);
    }
}
