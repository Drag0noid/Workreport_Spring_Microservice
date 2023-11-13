package com.example.WorkReport.Model;

import com.example.WorkReport.Entity.CompanyEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Company {
    private BigInteger id;
    private String name;

    public static Company toModelCompany(CompanyEntity companyEntity){
        Company model = new Company();
        model.setId(companyEntity.getId());
        model.setName(companyEntity.getName());
        return model;
    }
    public Company() {
    }
}
