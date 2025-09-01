package com.example.spring_boot_demo_brevo_integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_demo_brevo_integration.dto.EmailRequest;
import com.example.spring_boot_demo_brevo_integration.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

     @Autowired
    private EmailService emailService;

    //send a simple mail
    public ResponseEntity<String> sendTextEmail(@RequestBody EmailRequest emailRequest){
        
    }
}
