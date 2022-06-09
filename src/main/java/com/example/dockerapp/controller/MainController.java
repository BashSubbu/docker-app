package com.example.dockerapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class MainController {
    // more changes from feature branch 2
    @GetMapping("v1/message")
    public String getMessage(){
        return "Hello from Docker";
    }
    // same line changes from feature branch 2
    @GetMapping("v1/messages")
    public String getMessages(){
        return "Messages from dockers ....";
    }
}
