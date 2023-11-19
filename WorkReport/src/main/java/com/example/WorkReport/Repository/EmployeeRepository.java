package com.example.WorkReport.Repository;

import com.example.WorkReport.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, BigInteger> {
    @Query("select sum(salary) from EmployeeEntity \n" +
            "where surname IN (:param1, :param2)")
    List<String> joinSting(@Param("param1") String param1, @Param("param2") String param2);

    @Query(value = "SELECT e.id, e.job_title, e.end_date - e.start_date AS count_day_working " +
            "FROM employee e " +
            "WHERE e.end_date IS NOT NULL " +
            "GROUP BY e.id, e.job_title " +
            "ORDER BY count_day_working ASC " +
            "LIMIT 1", nativeQuery = true)
    List<String> joinString1();

    @Query("SELECT COUNT(*) AS count\n" +
            "FROM EmployeeEntity e\n" +
            "WHERE e.enddate IS NOT NULL\n" +
            "AND e.employee_company.id = (SELECT c.id FROM CompanyEntity c WHERE c.name = :param3)")
    List<String> joinString2(@Param("param3") String param3);


    @Query(value = "SELECT job_title " +
            "FROM employee " +
            "GROUP BY job_title " +
            "ORDER BY COUNT(job_title) DESC " +
            "LIMIT :limit", nativeQuery = true)
    List<String> joinString3(@Param("limit") int limit);

    @Query(value = "WITH job_statistics AS (\n" +
            "  SELECT e.job_title, o.city, ROUND(AVG(e.salary), 0) AS avg_salary, COUNT(*) AS count_employees\n" +
            "  FROM employee e\n" +
            "  INNER JOIN office o ON e.office_id = o.id\n" +
            "  GROUP BY e.job_title, o.city\n" +
            "  HAVING COUNT(*) >= :limit\n" +
            "),\n" +
            "max_avg_salary AS (\n" +
            "  SELECT job_title, MAX(avg_salary) AS max_avg_salary\n" +
            "  FROM job_statistics\n" +
            "  GROUP BY job_title\n" +
            ")\n" +
            "SELECT js.job_title, js.city, js.avg_salary, js.count_employees\n" +
            "FROM job_statistics js\n" +
            "INNER JOIN max_avg_salary mas ON js.job_title = mas.job_title\n" +
            "AND js.avg_salary = mas.max_avg_salary\n" +
            "ORDER BY js.avg_salary DESC",
            nativeQuery = true)
    List<String> joinString4(@Param("limit") int limit);
}
