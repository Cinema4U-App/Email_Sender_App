package com.a3.emailapplication.service;

import com.a3.emailapplication.constants.EmailTemplates;
import com.a3.emailapplication.dtos.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailDto email, EmailTemplates emailTemplates){

        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setFrom(email.getSentFrom());
            mimeMessageHelper.setTo(email.getSendTo());
            switch (emailTemplates){
                case SignUp: email.setContent(email.returnMailContent("D:\\An3_sem2\\PS(PROGRAMARE SOFTWARE)\\LAB\\ps-2022-30235-a3-Alexandra-Pop\\src\\main\\resources\\templates\\email.html")); break;
                case Ticket: email.setContent(email.returnMailContent("D:\\An3_sem2\\PS(PROGRAMARE SOFTWARE)\\LAB\\ps-2022-30235-a3-Alexandra-Pop\\src\\main\\resources\\templates\\ticket.html")); break;
            }
            mimeMessageHelper.setText(email.getContent(), true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
