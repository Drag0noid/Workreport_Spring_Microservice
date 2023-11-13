package com.example.WorkReport.Repository;

import com.example.WorkReport.Entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface CompanyRepository extends CrudRepository<CompanyEntity, BigInteger> {
    CompanyEntity findByName(String name);
}
