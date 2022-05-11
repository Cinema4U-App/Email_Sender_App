package com.a3.emailapplication.dtos;

import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private String firstName;
    private String lastName;
    private String email;
    private String movieName;
    private String director;
    private String time;
    private List<String> seats;

}
