package com.example.model.dto;

import lombok.Data;

@Data
public class WorkerWagesDTO {
    private Integer id;
    private String name;
    private Integer workingDays;
    private Integer wages;
    private Integer projectID;
}
