package com.allstudent.data.exception;

import java.util.Optional;

public final class Assert {

    private Assert() {}

    public static void entityNotFound(Boolean notFound, String field) {
        if (notFound) {
            throw new NotFoundException(field,null);
        }
    }
}
