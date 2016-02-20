/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningfalcons;

/**
 *
 * @author xinmin
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class sendEmail
 */
public class SendEmail {
    private String host = "";
    private String user = "";
    private String password = "";

    /**
     * Set the host
     * @param host a String
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Set the account
     * @param u a String
     * @param pw password a String
     */
    public void setAccount(String u, String pw) {
        this.user = u;
        this.password = pw;
    }

    /**
     * Send email
     * @param from a string
     * @param to a string
     * @param subject a string
     * @param content a String
     */
    public void send(String from, String to, String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host); // set SMTP host
        props.put("mail.smtp.auth", "true"); // need SMTP key?
        try {
            Session mailSession = Session.getDefaultInstance(props);
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from)); // from
            message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to)); //to
            message.setSubject(subject); // title
            message.setText(content); // content
            message.saveChanges();
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            System.out.println(e);
        }
    }

}
