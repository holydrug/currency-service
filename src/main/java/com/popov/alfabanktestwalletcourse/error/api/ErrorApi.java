package com.popov.alfabanktestwalletcourse.error.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
public class ErrorApi {

    private HttpStatus status;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private List<String> errors;
    private int errorCode;


    private ErrorApi() {
        timestamp = LocalDateTime.now();
    }

    public ErrorApi(HttpStatus status) {
        this();
        this.status = status;
    }

    public ErrorApi(HttpStatus status, String message, List<String> errors) {
        super();
        this.errorCode = status.value();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorApi(HttpStatus status, String message, String error) {
        super();
        this.errorCode = status.value();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
        this.timestamp = LocalDateTime.now();

    }


}

