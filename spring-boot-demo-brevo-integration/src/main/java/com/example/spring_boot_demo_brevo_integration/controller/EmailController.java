package com.example.spring_boot_demo_brevo_integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/send-text")
    //send a simple mail
    public ResponseEntity<String> sendTextEmail(@RequestBody EmailRequest request){
        try{
              System.out.println("Request received: " + request);
              
              emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
              return ResponseEntity.ok("Email sent successfully");
               
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Failed to send email" + e.getMessage());
        }
    }

    @PostMapping("/send-html")
    //send a html mail
    public ResponseEntity<String> sendHtmlEmail(@RequestBody EmailRequest request){
        try{
              System.out.println("Request received: " + request);
              emailService.sendHtmlEmail(request.getTo(), request.getSubject(), request.getBody());
              return ResponseEntity.ok("HTML Email sent successfully");
               
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Failed to send email" + e.getMessage());
        }
    }
}
