package com.allstudent.data.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public abstract class AssertionException extends RuntimeException {
    private final String field;

    protected AssertionException(String field, String message) {
        super(message);
        this.field = field;
    }

    public abstract AssertionErrorType type();

    public Map<String, String> parameters() {
        return Map.of();
    }
}
