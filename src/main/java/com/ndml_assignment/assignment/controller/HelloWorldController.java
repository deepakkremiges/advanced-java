package com.ndml_assignment.assignment.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ndml_assignment.assignment.utility.ApiRequest;
import com.ndml_assignment.assignment.utility.ApiResponse;


@RestController
public class HelloWorldController{

    // Problem 1.
    @GetMapping("/hello")
    public ResponseEntity<ApiResponse> sayHello() {
        Map<String, Object> data = new HashMap<>();
        data.put("msg", "Hello World");

        ApiResponse response = new ApiResponse("success", "200", " ", data, ApiResponse.generateRandomNumberString(9));
        response.setData("");
        return ResponseEntity.ok(response);
    }
    
    //Problem 2.
    @PostMapping("/hello")
    public ResponseEntity<ApiRequest> sayHello(@RequestBody ApiRequest apiRequest) {
       return ResponseEntity.ok(apiRequest);
    }


}


