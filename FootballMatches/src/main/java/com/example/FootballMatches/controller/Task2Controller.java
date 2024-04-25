package com.example.FootballMatches.controller;

import com.example.FootballMatches.service.Task2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Task2Controller {

    @Autowired
    private Task2Service task2Service;

    @GetMapping("/task2")
    public ResponseEntity<String> getTask2Data(@AuthenticationPrincipal UserDetails userDetails, @RequestParam int year) {
        return ResponseEntity.ok("Drawn Matches For Given Year : " + task2Service.fetchData(year));
    }
}
