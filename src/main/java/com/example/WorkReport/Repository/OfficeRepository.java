package com.example.WorkReport.Repository;

import com.example.WorkReport.Entity.OfficeEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface OfficeRepository extends CrudRepository<OfficeEntity, BigInteger> {
}
