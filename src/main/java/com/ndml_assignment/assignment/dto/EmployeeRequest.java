package com.ndml_assignment.assignment.dto;

import java.beans.JavaBean;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequest {
    private String empId;
    private String firstName;
    private String fullName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private Integer salary;
    private Long reportsTo; // Assuming reportsToId is the employee id of the reporting officer
    private Long departmentId;
    private Long rankId;
    private String clientReqId;

    public Object getReportingOfficerId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReportingOfficerId'");
    }
}
