//package com.example.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service ;
//
//import java.util.Date;
//
//@Service
//public class EmailService
//{
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Autowired
//    private SimpleMailMessage preConfiguredMessage;
//
//    /**
//     * This method will send compose and send the message
//     * */
//    public void sendMail(String to, String subject, String body)
//    {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("asal");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//        System.err.println(message);
//        mailSender.send(message);
//
//    }
//
//    /**
//     * This method will send a pre-configured message
//     * */
//    public void sendPreConfiguredMail(String message)
//    {
//        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
//        mailMessage.setText(message);
//        mailSender.send(mailMessage);
//    }
//}