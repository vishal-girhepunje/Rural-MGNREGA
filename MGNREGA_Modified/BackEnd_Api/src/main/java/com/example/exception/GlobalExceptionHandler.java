package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BdoException.class)
    public ResponseEntity<MyErrorDetails> bdoExceptionHandler(BdoException ex, WebRequest wb){
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ex.getMessage());
        err.setDetails(wb.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GpmException.class)
    public ResponseEntity<MyErrorDetails> gpmExceptionHandler(GpmException ex, WebRequest wb){
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ex.getMessage());
        err.setDetails(wb.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<MyErrorDetails> projectExceptionHandler(ProjectException ex, WebRequest wb){
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ex.getMessage());
        err.setDetails(wb.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WorkerException.class)
    public ResponseEntity<MyErrorDetails> WorkerExceptionHandler(WorkerException ex, WebRequest wb){
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ex.getMessage());
        err.setDetails(wb.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(MethodArgumentNotValidException ex){
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage("Validation Error!");
        err.setDetails(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(Exception ex, WebRequest wb){
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ex.getMessage());
        err.setDetails(wb.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
