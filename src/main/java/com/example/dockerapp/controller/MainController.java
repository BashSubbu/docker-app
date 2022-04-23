package com.example.dockerapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class MainController {
    @GetMapping("v1/message")
    public String getMessage(){
        return "Hello from Docker";
    }
    @GetMapping("v1/messages")
    public String getMessages(){
        return "Hello from dockers ";
    }
}
