package com.example.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyErrorDetails {
    private LocalDateTime time;
    private String message;
    private String details;
}
