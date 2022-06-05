package com.popov.alfabanktestwalletcourse.error;

import com.popov.alfabanktestwalletcourse.error.api.ErrorApi;
import com.popov.alfabanktestwalletcourse.error.general.AlfaBankException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends AlfaBankException {

    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<Object> handleMalformedUrl(URISyntaxException ex){
        List<String> errors = new ArrayList<>();

        ErrorApi error = new ErrorApi(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        error.setMessage(ex.getMessage());

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }
}
