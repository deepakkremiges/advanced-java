package com.deepak.advance_assignment.controller;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deepak.advance_assignment.dto.EmployeeDTO;
import com.deepak.advance_assignment.dto.EmployeeDetailsDTO;
import com.deepak.advance_assignment.entity.EmployeeEntity;
import com.deepak.advance_assignment.repository.EmployeeRepository;
import com.deepak.advance_assignment.response.ResponseHandler;
import com.deepak.advance_assignment.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/myhr/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Problem 7.
    @PostMapping("/add")
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {

            EmployeeEntity employeeEntity = EmployeeDTO.convertToEntity(employeeDTO);

            EmployeeEntity result = employeeService.addEmployee(employeeEntity);
            return ResponseHandler.generateResponse("success", HttpStatus.OK, result, "", Instant.now());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, "error",
                    Instant.now());
        }

    }

    // Problem 8.
    @GetMapping("/list")
    public ResponseEntity<Object> getEmployeeList() {

        try {

            List<Object[]> employees = employeeService.getEmployeeIdsAndNames(0);
            return ResponseHandler.generateResponse("success", HttpStatus.OK, employees, "", Instant.now());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, "error",
                    Instant.now());
        }
    }

    // Problem 9.

    @GetMapping("/lists")
    public ResponseEntity<Object> getFilterEmployee(@RequestParam(required = false) String filter) {
        try {
            List<EmployeeEntity> filteredEmployee = employeeService.findEmployeesbyFilter(filter);
            return ResponseHandler.generateResponse("success", HttpStatus.OK, filteredEmployee, "", Instant.now());

        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null, "error",
                    Instant.now());
        }
    }

    // Problem 10.
    // @GetMapping("/myhr/employee/get/{id}")
    // public ResponseEntity<Object> getEmployeeDetails(@PathVariable Long id) {
    // Optional<EmployeeDetailsDTO> employeeDetailsOptional =
    // employeeRepository.findEmployeeDetailsById(id);
    // if (employeeDetailsOptional.isPresent()) {
    // EmployeeDetailsDTO employeeDetails = employeeDetailsOptional.get();
    // return ResponseEntity.ok(employeeDetails);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }

}
