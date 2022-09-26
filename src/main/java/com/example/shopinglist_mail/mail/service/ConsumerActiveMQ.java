package com.example.shopinglist_mail.mail.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerActiveMQ {
    private final MailSenderService mailSenderService;
    private final ObjectMapper objectMapper;
    private final String SUBJECT = "Активация профиля по ссылке";

    public ConsumerActiveMQ(MailSenderService mailSenderService, ObjectMapper objectMapper) {
        this.mailSenderService = mailSenderService;
        this.objectMapper = objectMapper;
    }


    @JmsListener(destination = "email_to_sender")
    public void receiveMess(String mess){
        JsonNode node = null;
        try {
            node = objectMapper.readTree(mess);
            var emailTo = node.findValue("mail").asText();
            var codeFrom = node.findValue("code").asText();

            mailSenderService.sendMail(emailTo,SUBJECT,codeFrom);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(mess + " ==  отправленно");
    }
}
