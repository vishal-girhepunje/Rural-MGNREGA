package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wID")
    private Integer id;

    @Column(name = "wName")
    private String workerName;

    @Column(name = "wAadhaar", unique = true)
    private String aadhaar;

    @Column(name = "wDob")
    private LocalDate dob;

    @Column(name = "wGender")
    private String gender;

    private String gpName;

    @Column(name = "workStrDate")
    private LocalDate workStartDate;

    private String district;

    private String state;

//    @Column(name = "is_delete")
//    private boolean isDelete;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gpmID")
    private GPM gpm;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "proID")
    private Project project;

}
