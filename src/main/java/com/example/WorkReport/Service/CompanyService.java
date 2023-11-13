package com.example.WorkReport.Service;

import com.example.WorkReport.Entity.CompanyEntity;
import com.example.WorkReport.Exceptions.CompanyAlreadyExist;
import com.example.WorkReport.Exceptions.CompanyNotFound;
import com.example.WorkReport.Model.Company;
import com.example.WorkReport.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity registration(CompanyEntity company) throws CompanyAlreadyExist {
        if(companyRepository.findByName(company.getName()) != null){
            throw new CompanyAlreadyExist("Такая компания уже существует");
        }
        return companyRepository.save(company);
    }
    public Company getOne(BigInteger id) throws CompanyNotFound {
        CompanyEntity company = companyRepository.findById(id).get();
        if(company == null){
            throw new CompanyNotFound("Компания не найдена");
        }
        return Company.toModelCompany(company);
    }
}
