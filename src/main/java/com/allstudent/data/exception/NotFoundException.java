package com.allstudent.data.exception;

public class NotFoundException extends AssertionException {

    public NotFoundException(String field, String message) {
        super(field, field+" not found");
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NOT_FOUND_EXCEPTION;
    }
}
