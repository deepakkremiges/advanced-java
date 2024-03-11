package com.ndml_assignment.assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ndml_assignment.assignment.utility.ApiRequest;
import com.ndml_assignment.assignment.utility.ApiResponse;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MyCalcController {

    @PostMapping("/mycalc")
    public ResponseEntity<ApiResponse> myCalc(@RequestBody ApiRequest request) {
        try {
            String operation = (String) request.getData().get("operation");
            List<Double> numbers = ((List<Integer>) request.getData().get("numbers")).stream()
                    .map(Double::valueOf)
                    .collect(Collectors.toList());

            double result = 0;
            String operationExecuted = "";

            switch (operation) {
                case "mean":
                    result = calculateMean(numbers);
                    operationExecuted = "Mean value";
                    break;
                case "min":
                    result = Collections.min(numbers);
                    operationExecuted = "Minimum value";
                    break;
                case "max":
                    result = Collections.max(numbers);
                    operationExecuted = "Maximum value";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            ApiResponse response = new ApiResponse("success", "", "", Map.of("result", result, "operationExecuted", operationExecuted), request.getReqId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return handleException(e, request.getReqId());
        }
    }

    private double calculateMean(List<Double> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Cannot calculate mean value for an empty list.");
        }
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        return sum / numbers.size();
    }

    private ResponseEntity<ApiResponse> handleException(Exception e, String reqId) {
        ApiResponse errorResponse = new ApiResponse();
        errorResponse.setStatus("error");
        errorResponse.setStatusCode("INTERNAL_ERROR");
        errorResponse.setStatusMsg(e.getMessage());
        errorResponse.setReqId(reqId);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

