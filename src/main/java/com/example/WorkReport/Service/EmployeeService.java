package com.example.WorkReport.Service;

import com.example.WorkReport.Entity.EmployeeEntity;
import com.example.WorkReport.Entity.OfficeEntity;
import com.example.WorkReport.Exceptions.EmployeeNotFound;
import com.example.WorkReport.Exceptions.OfficeNotFound;
import com.example.WorkReport.Model.Employee;
import com.example.WorkReport.Model.Office;
import com.example.WorkReport.Repository.CompanyRepository;
import com.example.WorkReport.Repository.EmployeeRepository;
import com.example.WorkReport.Repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public Employee getEmployee(BigInteger companyId) throws EmployeeNotFound {
        EmployeeEntity employee = employeeRepository.findById(companyId).get();
        if(employee == null){
            throw new EmployeeNotFound("Сотрудник не найден");
        }
        return Employee.toModelEmployee(employee);
    }
}
