package com.example.WorkReport.Controller;

import com.example.WorkReport.Exceptions.EmployeeNotFound;
import com.example.WorkReport.Exceptions.OfficeNotFound;
import com.example.WorkReport.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/employee")
public class EmployeeEntity {

    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity getEmployee(@RequestParam BigInteger companyId){
        try {
            return ResponseEntity.ok().body(employeeService.getEmployee(companyId));
        } catch (EmployeeNotFound e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
