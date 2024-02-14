package com.srijanmukherjee.yeetcode.service.impl;

import com.srijanmukherjee.yeetcode.service.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailServiceImpl implements EmailService {
    JavaMailSender emailSender;

    @NonFinal
    @Value("${confirmation_code_validity}")
    Integer confirmationCodeValidity;

    @Override
    public void sendAccountConfirmationCode(String to, String code) {
        var message = new SimpleMailMessage();
        message.setFrom("yeetcode@srijanmukherjee.in");
        message.setTo(to);
        message.setSubject("Confirm your yeetcode account");
        message.setText("Your confirmation code is %s. It will expire in %d minutes"
                .formatted(code, confirmationCodeValidity));
        emailSender.send(message);
    }
}
