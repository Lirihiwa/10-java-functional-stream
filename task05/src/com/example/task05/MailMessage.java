package com.example.task05;

public class MailMessage extends ISendable<String>{
    public MailMessage(String from, String to, String message) {
        super(from, to, message);
    }
}
