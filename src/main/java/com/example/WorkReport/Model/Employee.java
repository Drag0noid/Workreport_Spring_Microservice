package com.example.WorkReport.Model;

import com.example.WorkReport.Entity.EmployeeEntity;
import com.example.WorkReport.Entity.OfficeEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class Employee {
    private BigInteger id;
    private String name;
    private String surname;
    private Date birthdate;
    private String email;
    private String jobtitle;
    private Integer salary;
    private Date startdate;
    private Date enddate;

    public static Employee toModelEmployee(EmployeeEntity entity){
        Employee model = new Employee();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setBirthdate(entity.getBirthdate());
        model.setEmail(entity.getEmail());
        model.setJobtitle(entity.getJobtitle());
        model.setSalary(entity.getSalary());
        model.setStartdate(entity.getStartdate());
        model.setEnddate(entity.getEnddate());
        return model;
    }

    public Employee() {
    }
}
