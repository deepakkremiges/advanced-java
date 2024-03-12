package com.deepak.advance_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDTO {
    private String fullName;
    private String rankDescription;
    private String departmentName;
    private String supervisorName;

}
