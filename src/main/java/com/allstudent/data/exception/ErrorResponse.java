package com.allstudent.data.exception;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private int statusCode;
    private String message;
    private String title;
    private String url;
}
