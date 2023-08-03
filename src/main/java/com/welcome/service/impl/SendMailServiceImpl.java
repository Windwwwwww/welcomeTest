package com.welcome.service.impl;

import com.welcome.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setFrom(from);
        msg.setSubject(subject);
        msg.setText(content);
        msg.setTo(to);
        mailSender.send(msg);

    }
}
