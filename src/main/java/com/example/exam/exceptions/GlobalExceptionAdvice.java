package com.example.exam.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler({PreferedTimeException.class})
    public ResponseEntity handle(PreferedTimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler({ErrorUpdateException.class})
    public ResponseEntity handle(ErrorUpdateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({DeliverNotFoundException.class})
    public ResponseEntity handle(DeliverNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body("Invalid value : " + e.getFieldError().getRejectedValue() +
                        " for field " + e.getFieldError().getField() +
                        " with message: " + e.getFieldError().getDefaultMessage());
    }
}
