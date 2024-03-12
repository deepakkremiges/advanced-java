package com.deepak.advance_assignment.dto;

import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import com.deepak.advance_assignment.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String empId;
    private String firstName;
    private String fullName;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private int salary;
    private long reportsTo;
    private long deptid;
    private long rankid;
    private Date createdAt;
    private Date updatedAt;
    private String clientReqId = generateRandomString(9);

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomString(int length) {
        return new Random().ints(length, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static EmployeeEntity convertToEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(employeeDTO.getEmpId());
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setFullName(employeeDTO.getFullName());
        employeeEntity.setDateOfBirth(employeeDTO.getDateOfBirth());
        employeeEntity.setDateOfJoining(employeeDTO.getDateOfJoining());
        employeeEntity.setSalary(employeeDTO.getSalary());
        employeeEntity.setReportsTo(employeeDTO.getReportsTo());
        employeeEntity.setClientReqId(employeeDTO.getClientReqId());

        return employeeEntity;
    }

}
