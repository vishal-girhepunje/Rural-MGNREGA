package com.example.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class WorkerDTO {
    private Integer id;
    private String workerName;
    private String aadhaar;
    private LocalDate dob;
    private String gender;
    private String gpName;
    private LocalDate workStartDate;
    private String district;
    private String state;
}
