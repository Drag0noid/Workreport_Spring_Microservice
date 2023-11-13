package com.example.WorkReport.Controller;

import com.example.WorkReport.Entity.OfficeEntity;
import com.example.WorkReport.Exceptions.CompanyNotFound;
import com.example.WorkReport.Exceptions.OfficeNotFound;
import com.example.WorkReport.Service.CompanyService;
import com.example.WorkReport.Service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

//    @PostMapping
//    public ResponseEntity createOffice(@RequestBody OfficeEntity office,
//                                       @RequestParam BigInteger companyId){
//        try {
//            return ResponseEntity.ok(officeService.createOffice(office,companyId));
//        } catch (Exception e){
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }

    @GetMapping()
    public ResponseEntity getOffice(@RequestParam BigInteger companyId){
        try {
            return ResponseEntity.ok().body(officeService.getOffice(companyId));
        } catch (OfficeNotFound e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
