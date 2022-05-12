package com.a3.emailapplication.controller;

import com.a3.emailapplication.constants.EmailTemplates;
import com.a3.emailapplication.dtos.EmailDto;
import com.a3.emailapplication.dtos.UserDto;
import com.a3.emailapplication.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QueueListener {

    @Autowired
    EmailService emailService;

    @Bean
    public MessageConverter jsonMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @RabbitListener(queues = "email-queue")
    public void listen(UserDto userDto){
        System.err.println(userDto);
        Map<String, String> model = new HashMap<>();
        model.put("$%{firstName}%", userDto.getFirstName());
        model.put("$%{lastName}%", userDto.getLastName());
        model.put("$%{movieName}%", "Avengers");
        model.put("$%{director}%", "Joe Russo");
        model.put("$%{seatNb}%", "2");
        model.put("$%{datetime}%", "12.05.2022 16:00");
        EmailDto emailDto = EmailDto.builder().sendTo(userDto.getEmail()).sentFrom("Cinema4UApp").subject("Ticket Confirmation").model(model).build();
        emailService.sendEmail(emailDto, EmailTemplates.Ticket);
    }

}
