package com.example.WorkReport.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private List<OfficeEntity> offices;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee1")
    private List<EmployeeEntity> employee;

    public CompanyEntity() {
    }

}
