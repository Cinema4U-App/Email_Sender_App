package com.a3.emailapplication.controller;

import com.a3.emailapplication.constants.EmailTemplates;
import com.a3.emailapplication.dtos.UserDto;
import com.a3.emailapplication.dtos.UserDtoToEmailDto;
import com.a3.emailapplication.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    private String uuid = "9d09d31e-e9e2-44c0-84be-5b3de26167c75dab64e7-c789-4418-9afa-777fcecf01f8";

    @PostMapping("/sendEmail")
    public ResponseEntity<UserDto> sendEmail(@RequestHeader HttpHeaders httpHeaders, @RequestBody UserDto userDto){
        System.err.println(userDto.toString());
        System.err.println(httpHeaders.getFirst(HttpHeaders.AUTHORIZATION));
        String authorization = "Bearer " + this.uuid;
        if(authorization.equals(httpHeaders.getFirst(HttpHeaders.AUTHORIZATION))){
            UserDtoToEmailDto mapper = new UserDtoToEmailDto();
            emailService.sendEmail(mapper.toEmailDto(userDto), EmailTemplates.SignUp);
            return ResponseEntity.ok(userDto);
        }
        else{
            return ResponseEntity.badRequest().body(userDto);
        }
    }

}
