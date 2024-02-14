package com.srijanmukherjee.yeetcode.service;

public interface EmailService {
    void sendAccountConfirmationCode(String to, String code);
}
