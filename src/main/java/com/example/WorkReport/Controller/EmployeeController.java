package com.example.WorkReport.Controller;

import com.example.WorkReport.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/employee")
public class EmployeeEntity {

    private EmployeeService employeeService;

    @GetMapping(path = "/{id}")
    public EmployeeEntity getEmployee(@PathVariable BigInteger Id){
        return employeeService.getEmployee(Id);
    }

}
