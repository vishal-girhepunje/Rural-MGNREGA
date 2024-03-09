package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proID")
    private Integer id;

    @Column(name = "proName")
    private String projectName;

    @Column(name = "proStrDate")
    private Date startDate;

    @Column(name = "proEndDate")
    private Date endDate;

    @Column(name = "noOfWorkers")
    private int numberOfWorkers;

    private int wagesPerDay;

//    @Column(name = "is_delete")
//    private boolean isDelete;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gpmID")
    private GPM gpm;

//    @ManyToOne
//    @JoinColumn(name = "bdoID")
//    private BDO bdo;

}

