package com.example.WorkReport.Repository;

import com.example.WorkReport.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, BigInteger> {
    @Query(value="select e from EmployeeEntity e")
    List<EmployeeEntity> findAllBByA_aId(BigInteger id);

}
