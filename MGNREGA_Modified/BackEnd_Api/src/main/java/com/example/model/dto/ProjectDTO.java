package com.example.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {
    private Integer id;
    private String projectName;
    private Date startDate;
    private Date endDate;
    private int wagesPerDay;
    private int numberOfWorkers;
}
