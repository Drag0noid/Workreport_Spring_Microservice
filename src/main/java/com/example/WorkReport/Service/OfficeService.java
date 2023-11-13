package com.example.WorkReport.Service;

import com.example.WorkReport.Entity.CompanyEntity;
import com.example.WorkReport.Entity.OfficeEntity;
import com.example.WorkReport.Exceptions.CompanyNotFound;
import com.example.WorkReport.Exceptions.OfficeNotFound;
import com.example.WorkReport.Model.Office;
import com.example.WorkReport.Repository.CompanyRepository;
import com.example.WorkReport.Repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private CompanyRepository companyRepository;

//    public OfficeEntity createOffice(OfficeEntity office, BigInteger companyId){
//        CompanyEntity company = companyRepository.findById(companyId).get();
//        office.setCompanies(company);
//        return officeRepository.save(office);
//
//    }

    public Office getOffice(BigInteger companyId) throws OfficeNotFound {
        OfficeEntity office = officeRepository.findById(companyId).get();
        if(office == null){
            throw new OfficeNotFound("Офис не найден");
        }
        return Office.toModelOffice(office);
    }
}
