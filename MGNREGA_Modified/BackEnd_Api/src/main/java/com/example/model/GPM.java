package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class GPM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gpmID")
    private Integer id;

    @Column(name = "gpmName")
    private String name;

    @Column(name = "gpmAadhaar", unique = true)
    private String aadhaar;

    @Column(name = "gpmDob")
    private LocalDate dob;

    @Column(name = "gpmGender")
    private String gender;

    @Column(name = "gpmEmail", unique = true)
    private String email;

    @Column(name = "gpmPassword")
    private String password;

    @Column(name = "gpName", unique = true)
    private String gpName;

    private String district;

    private String state;

//    @Column(name = "is_delete")
//    private boolean isDelete;

    private String role;

//    @ManyToOne
//    @JoinColumn(name = "bdoID")
//    private BDO bdo;

    @JsonIgnore
    @OneToMany(mappedBy = "gpm", cascade = CascadeType.ALL)
    private List<Project> projects;

    @JsonIgnore
    @OneToMany(mappedBy = "gpm", cascade = CascadeType.ALL)
    private List<Worker> workers;

}

