package com.example.WorkReport.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;
    private String surname;
    private Date birthdate;
    private String email;
    private String jobtitle;
    private Integer salary;
    private Date startdate;
    private Date enddate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity employee1;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private OfficeEntity employees;

    public EmployeeEntity() {
    }
}
