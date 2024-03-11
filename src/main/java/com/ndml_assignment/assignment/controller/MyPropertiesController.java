package com.ndml_assignment.assignment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndml_assignment.assignment.utility.ApiRequest;
import com.ndml_assignment.assignment.utility.ApiResponse;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class MyPropertiesController {

    @Value("${my.property1:NULL}")
    private String property1;

    @Value("${my.property2:NULL}")
    private String property2;

    @Value("${my.property3:NULL}")
    private String property3;

    @PostMapping("/myproperties")
    public ResponseEntity<ApiResponse> getProperties(@RequestBody ApiRequest request) {
        try {
            List<String> propertyIdentifiers = (List<String>) request.getData().get("propertyIdentifiers");
            Map<String, Object> result = new HashMap<>();

            propertyIdentifiers.forEach(identifier -> {
                switch (identifier) {
                    case "property1":
                        result.put("property1", property1);
                        break;
                    case "property2":
                        result.put("property2", property2);
                        break;
                    case "property3":
                        result.put("property3", property3);
                        break;
                    default:
                        result.put(identifier, "NULL");
                }
            });

            ApiResponse response = new ApiResponse("success", "", "", result, request.getReqId());
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

