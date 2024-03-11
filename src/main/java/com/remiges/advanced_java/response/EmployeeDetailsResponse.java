package com.remiges.advanced_java.response;

import com.remiges.advanced_java.entity.Employee;

public class EmployeeDetailsResponse {

    private Employee employee;
    private String deptnane;
    private String rankdesc;

    public EmployeeDetailsResponse(Employee employee, String deptnane, String rankdesc) {
        this.employee = employee;
        this.deptnane = deptnane;
        this.rankdesc = rankdesc;
    }

}
