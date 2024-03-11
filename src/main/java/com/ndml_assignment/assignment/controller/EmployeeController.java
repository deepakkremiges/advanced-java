package com.ndml_assignment.assignment.controller;

import com.ndml_assignment.assignment.dto.EmployeeRequest;
import com.ndml_assignment.assignment.entity.Employee;
import com.ndml_assignment.assignment.service.EmployeeService;
import com.ndml_assignment.assignment.utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myhr/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        ApiResponse response = employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
