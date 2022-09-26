package com.example.shopinglist_mail.mail.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2SmileDecoder;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class ObjectMapperConf {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
