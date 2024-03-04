package com.ndml_assignment.assignment.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ndml_assignment.assignment.utility.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


//Problem: 1

@RestController
public class GreetMsg {

    
    @GetMapping("/hello")
    public ApiResponse greetMsg() {
        try {
            return new ApiResponse("success", "200", "Hello World");
        } catch (Exception e) {
            return new ApiResponse("error", "500", "Internal Server Error");
        }
    }

    
    @PostMapping("/hello")
    public ApiResponse greetMsgName(@RequestParam String name) {
        try {
            return new ApiResponse("success", "200", "Hello "+name);
        } catch (Exception e) {
            return new ApiResponse("error", "500", "Internal Server Error");
        }
    }
    
    
    
}
