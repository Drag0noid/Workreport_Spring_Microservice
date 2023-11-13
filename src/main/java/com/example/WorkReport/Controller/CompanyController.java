package com.example.WorkReport.Controller;

import com.example.WorkReport.Entity.CompanyEntity;
import com.example.WorkReport.Exceptions.CompanyAlreadyExist;
import com.example.WorkReport.Exceptions.CompanyNotFound;
import com.example.WorkReport.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @PostMapping()
    public ResponseEntity registration(@RequestBody CompanyEntity company){
        try {
            companyService.registration(company);
            return ResponseEntity.ok().body("Добавлена компания");
        } catch (CompanyAlreadyExist e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping()
    public ResponseEntity getCompany(@RequestParam BigInteger id){
        try {
            return ResponseEntity.ok().body(companyService.getOne(id));
        } catch (CompanyNotFound e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
