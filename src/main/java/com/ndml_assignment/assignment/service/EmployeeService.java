package com.ndml_assignment.assignment.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ndml_assignment.assignment.dao.DepartmentRepository;
import com.ndml_assignment.assignment.dao.EmployeeRepository;
import com.ndml_assignment.assignment.dao.RankRepository;
import com.ndml_assignment.assignment.dto.EmployeeRequest;
import com.ndml_assignment.assignment.utility.ApiResponse;

import jakarta.transaction.Transactional;

import com.ndml_assignment.assignment.entity.Department;
import com.ndml_assignment.assignment.entity.Employee;
import com.ndml_assignment.assignment.entity.Rank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RankRepository rankRepository;

    public ApiResponse addEmployee(EmployeeRequest employeeRequest) {
        try {
            // Convert EmployeeRequest to Employee entity
            Employee employee = convertToEmployee(employeeRequest);

            // Save the employee
            Employee savedEmployee = employeeRepository.save(employee);

            // Return the saved employee data in the response
            return new ApiResponse("success", "", "", savedEmployee, employeeRequest.getClientReqId());
        } catch (DataIntegrityViolationException e) {
            // Handle duplicate id or other data integrity violations
            // return new ApiResponse("error", "DATA_INTEGRITY_ERROR", "Data integrity
            // violation", null,
            // employeeRequest.getClientReqId());

            return new ApiResponse("error", "DATA_INTEGRITY_ERROR", "Data integrity violation", new Object(),
                    employeeRequest.getClientReqId());

        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            // Handle other exceptions
            // return new ApiResponse("error", "INTERNAL_ERROR", "Internal server error",
            // null,
            // employeeRequest.getClientReqId());
            return new ApiResponse("error", "DATA_INTEGRITY_ERROR", "Data integrity violation", new Object(),
                    employeeRequest.getClientReqId());

        }
    }

    private Employee convertToEmployee(EmployeeRequest employeeRequest) {
        // Convert EmployeeRequest to Employee entity
        Employee employee = new Employee();
        employee.setEmpId(employeeRequest.getEmpId());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setFullName(employeeRequest.getFullName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setDateOfJoining(employeeRequest.getDateOfJoining());
        employee.setSalary(employeeRequest.getSalary());

        // Set reporting officer
        if (employeeRequest.getReportsTo() != null) {
            Optional<Employee> reportingOfficerOptional = employeeRepository.findById(employeeRequest.getReportsTo());
            reportingOfficerOptional.ifPresent(employee::setReportsToId);
        }

        // Set department
        if (employeeRequest.getDepartmentId() != null) {
            Optional<Department> departmentOptional = departmentRepository.findById(employeeRequest.getDepartmentId());
            departmentOptional.ifPresent(employee::setDepartment);
        }

        // Set rank
        if (employeeRequest.getRankId() != null) {
            Optional<Rank> rankOptional = rankRepository.findById(employeeRequest.getRankId());
            rankOptional.ifPresent(employee::setRank);
        }

        // Set clientReqId
        if (employeeRequest.getClientReqId() != null && !employeeRequest.getClientReqId().isEmpty()) {
            employee.setClientReqId(employeeRequest.getClientReqId());
        }

        // Set createdAt to current date and time
        employee.setCreatedAt(LocalDateTime.now());

        return employee;
    }
}
