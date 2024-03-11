package com.ndml_assignment.assignment.utility;

import java.beans.JavaBean;
import java.time.Instant;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.ndml_assignment.assignment.entity.Employee;

import lombok.Data;

@JavaBean
@Data
public class ApiResponse {

    private String status;
    private String statusCode;
    private String statusMsg;
    private Map<String, Object> data;
    private String reqId;
    private Instant serverTs;



    public ApiResponse(String status, String statusCode, String statusMsg, Map<String, Object> object, String reqId) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.data = (Map<String, Object>) object;
        this.reqId = reqId;
        this.serverTs = Instant.now();
    }

    public ApiResponse() {
        // TODO Auto-generated constructor stub
    }

    public ApiResponse(String string, String string2, String string3) {
        // TODO Auto-generated constructor stub
    }

    public ApiResponse(String status2, String statusCode2, String statusMsg2, Employee employee, String clientReqId) {
        // TODO Auto-generated constructor stub
    }

    public ApiResponse(String status2, String statusCode2, String statusMsg2, Object object, String clientReqId) {
        // TODO Auto-generated constructor stub
    }

    // to get the data
    public void setData(String string) {
        // TODO Auto-generated method stub
        return;
    }

    public void setData(Map<String, Object> responseData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setData'");
    }

    // to get random number
    public static String generateRandomNumberString(int length) {
        Random random = new Random();
        return random.ints(length, 0, 10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
