package com.a3.emailapplication.dtos;

import lombok.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private String sendTo;
    private String sentFrom;
    private String subject;
    private String content;
    private Map<String, String> model;

    public String returnMailContent(String template){
        StringBuilder content = new StringBuilder();
        try {
            List<String[]> fileWords = Files.lines(Path.of(template)).map(s -> s.split(" ")).collect(Collectors.toList());
            for(String[] str: fileWords){
                for(String s: str){
                    String value = Stream.of(model).filter(i -> i.containsKey(s)).map(i -> i.get(s)).collect(Collectors.joining());
                    String newS = s;
                    if(!value.equals("")){ newS = value; }
                    content.append(" ").append(newS);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        return content.toString();
    }

}
