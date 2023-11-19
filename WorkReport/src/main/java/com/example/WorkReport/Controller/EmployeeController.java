package com.example.WorkReport.Controller;

import com.example.WorkReport.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/avgSalary")
    public List<String> joinString(@RequestBody Map<String, String> params) {
        String param1 = params.get("param1");
        String param2 = params.get("param2");
        return employeeRepository.joinSting(param1, param2);
    }
    @GetMapping("/dismissed-employee")
    public List<String> getjoinString1() {
        return employeeRepository.joinString1();
    }

    @PostMapping("/Count")
    public List<String> joinString2(@RequestBody Map<String, String> params) {
        String param3 = params.get("param3");
        return employeeRepository.joinString2(param3);
    }

        @PostMapping("/job")
        public List<String> GetjoinString3(@RequestBody Map<String, String> params) {
            int limit = Integer.parseInt(params.get("param4"));
            return employeeRepository.joinString3(limit);
        }

    @PostMapping("/city")
    public List<String> GetjoinString4(@RequestBody Map<String, String> params) {
        int limit = Integer.parseInt(params.get("param5"));
        return employeeRepository.joinString4(limit);
    }
}
