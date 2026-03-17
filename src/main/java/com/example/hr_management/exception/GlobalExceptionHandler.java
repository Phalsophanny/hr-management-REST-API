package com.example.hr_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔥 Validation error (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // 🔥 Not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404, LocalDateTime.now()));
    }

    // 🔥 Bad request
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400, LocalDateTime.now()));
    }

    // 🔥 Server error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAll(Exception ex) {
        ex.printStackTrace(); // 🔥 show real error in console

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage(), 500, LocalDateTime.now()));
    }
}
