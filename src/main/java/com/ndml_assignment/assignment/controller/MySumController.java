package com.ndml_assignment.assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ndml_assignment.assignment.utility.ApiRequest;
import com.ndml_assignment.assignment.utility.ApiResponse;

import java.util.Map;



import java.time.Instant;


@RestController
public class MySumController {

    @PostMapping("/mysum")
    public ResponseEntity<ApiResponse> mySum(@RequestBody ApiRequest request) {
        String operation = (String) request.getData().get("operation");
        Number num1Obj = (Number) request.getData().get("num1");
        Number num2Obj = (Number) request.getData().get("num2");

        // Convert num1Obj and num2Obj to double
        double num1 = num1Obj.doubleValue();
        double num2 = num2Obj.doubleValue();
        try {
            // Perform operation
            double result;
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    if (num2 == 0) {
                        throw new IllegalArgumentException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            ApiResponse response = new ApiResponse("success", "", "", Map.of("result", result), request.getReqId());
            response.setServerTs(Instant.now());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return handleException(e, request.getReqId());
        }
    }

    private ResponseEntity<ApiResponse> handleException(Exception e, String reqId) {
        ApiResponse errorResponse = new ApiResponse();
        errorResponse.setStatus("error");
        errorResponse.setStatusCode("INTERNAL_ERROR");
        errorResponse.setStatusMsg(e.getMessage());
        errorResponse.setReqId(reqId);
        errorResponse.setServerTs(Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
