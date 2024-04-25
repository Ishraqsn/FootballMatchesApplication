package com.example.FootballMatches.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Task1Controller {

    @GetMapping("/task1")
    public ResponseEntity<String> getTask1Data(@AuthenticationPrincipal UserDetails userDetails) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("username", userDetails.getUsername());
        return ResponseEntity.ok("Task 1 Data for " + userDetails.getUsername());
    }
}