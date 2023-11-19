package com.example.WorkReport.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "office")
public class OfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String country;
    private String city;
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company_office;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee_office")
    private List<EmployeeEntity> employee;

    public OfficeEntity() {
    }


}
