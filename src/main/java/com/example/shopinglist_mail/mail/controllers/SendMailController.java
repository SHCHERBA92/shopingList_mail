package com.example.shopinglist_mail.mail.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {

    @PostMapping(value = "senderMail", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ggg(@RequestBody Object o){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o);
        return "null";
    }
//    @GetMapping(value = "senderMail")
//    public String ggdag(){
//        System.out.println("hello");
//        return "null";
//    }
}
