package com.remiges.advanced_java.controller;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.remiges.advanced_java.entity.Employee;
import com.remiges.advanced_java.response.EmployeeResponse;
import com.remiges.advanced_java.service.EmployeeService;

@RestController
@RequestMapping("/myhr/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Q No.- 07
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Q NO.- 08 or 09
    @GetMapping("/list")
    public ResponseEntity<EmployeeResponse> listEmployees() {
        List<Object[]> employees = employeeService.listEmployees();
        EmployeeResponse employeeResponse = new EmployeeResponse("200", "Success", employees, "swg", Instant.now());
        return ResponseEntity.ok().body(employeeResponse);
    }

    // Q.no- 10
    @GetMapping("/get")
    public ResponseEntity<Employee> getEmployeeDetails(@RequestParam Long id) {
        Optional<Employee> employeeDetails = employeeService.getEmployeeDetails(id);

        if (employeeDetails.isPresent()) {

            Employee employee = employeeDetails.get();
            Long fetchById = employee.getId();

            EmployeeResponse employeeResponse = new EmployeeResponse("200", "success", employee, fetchById, "randomid",
                    Instant.now());
            return ResponseEntity.ok().body(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
