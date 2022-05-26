package com.fatec.bibliotecanos.services;

public interface IEmailService {

    void sendMail(String toEmail,
                  String body,
                  String subject);

}
