package com.example.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class GpmDTO {
    private Integer id;
    private String name;
    private String aadhaar;
    private LocalDate dob;
    private String gender;
    private String email;
    private String password;
    private String gpName;
    private String district;
    private String state;
}
