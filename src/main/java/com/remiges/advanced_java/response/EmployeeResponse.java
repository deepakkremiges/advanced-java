package com.remiges.advanced_java.response;

import java.beans.JavaBean;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.remiges.advanced_java.entity.Employee;

import lombok.Data;

@JavaBean
@Data
public class EmployeeResponse {

    private static final org.springframework.http.HttpStatusCode HttpStatusCode = null;
    public String statusCode;
    public String statusMsg;
    public List<Object[]> data;
    // public Employee data;
    // private String fetchById;
    public String reqId;
    public Instant serverTs;

    public EmployeeResponse(String statusCode, String statusMsg, List<Object[]> data, String reqId, Instant serverTs) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.data = data;
        this.reqId = reqId;
        this.serverTs = serverTs;
    }

    public EmployeeResponse(String statusCode2, String statusMsg2, Employee employee, Long fetchById, Instant now) {

    }

    public EmployeeResponse(String string, String string2, Employee employee, Long fetchById, String string3,
            Instant now) {

    }

    public EmployeeResponse() {
        // TODO Auto-generated constructor stub
    }

}
