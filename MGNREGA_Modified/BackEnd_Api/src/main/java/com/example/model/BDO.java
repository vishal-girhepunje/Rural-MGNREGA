package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//@Entity
@Data
public class BDO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bdoID")
    private Integer id;

    @Column(name = "bdoName")
    private String name;

    @Column(name = "bdoEmail", unique = true)
    private String email;

    @Column(name = "bdoPassword")
    private String password;

    private String district;

    private String state;

    @Column(name = "is_delete")
    private boolean isDelete;

//    @OneToMany(mappedBy = "bdo", cascade = CascadeType.ALL)
//    private List<GPM> gpms;
//
//    @OneToMany(mappedBy = "bdo", cascade = CascadeType.ALL)
//    private List<Project> projects;
}
