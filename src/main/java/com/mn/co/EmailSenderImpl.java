package com.mn.co;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderImpl implements  EmailSender{


    private JavaMailSender javaMailSender;

    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    Logger logger= LoggerFactory.getLogger(EmailSenderImpl.class);
    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom("mrsharma9015@gmail.com");
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);
        logger.info("Email Has been sent ");
    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {

    }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlContent) {
        MimeMessage simplemessage=javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(simplemessage, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent,true);

        } catch (RuntimeException | MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(simplemessage);
        logger.info("Email Has been sent ");
    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {
        MimeMessage simplemessage=javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(simplemessage, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            FileSystemResource file1=
            helper.addAttachment(file.getName(), );

        } catch (RuntimeException | MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(simplemessage);
        logger.info("Email Has been sent ");
    }
}
