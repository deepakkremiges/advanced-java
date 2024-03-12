package com.deepak.advance_assignment.response;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObject,
            String status_msg, Instant instant) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObject);
        map.put("status_msg", status_msg);
        // map.put("req_id", req_id);
        map.put("server_ts", instant);
        return new ResponseEntity<Object>(map, status);
    }
}
