package com.a3.emailapplication.dtos;

import java.util.HashMap;
import java.util.Map;

public class UserDtoToEmailDto {

    public EmailDto toEmailDto(UserDto userDto){
        Map<String, String> model = new HashMap<>();
        model.put("$%{firstName}%", userDto.getFirstName());
        model.put("$%{lastName}%", userDto.getLastName());
        return EmailDto.builder().sendTo(userDto.getEmail()).sentFrom("cinema4UApp").subject("Register Confirmation").model(model).build();
    }

}
