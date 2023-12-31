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

    @Column(name = "job_title")
    private String jobtitle;

    private Integer salary;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date enddate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity employee_company;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private OfficeEntity employee_office;

    public EmployeeEntity() {
    }
}
