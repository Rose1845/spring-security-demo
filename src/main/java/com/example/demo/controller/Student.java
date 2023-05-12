package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student {

    @GetMapping("/message")
    public String getNewMessage(){
        return "spring security worked";
    }
}
