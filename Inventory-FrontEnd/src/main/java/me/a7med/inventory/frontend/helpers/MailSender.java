/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.a7med.inventory.frontend.helpers;

import java.util.Date;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ahmed_darweeesh
 */
@Named
@RequestScoped
public class MailSender {

    @Resource(lookup = "mailSender")
    private Session mailSession;
    private String to;
    private String subject;
    private String body;
    
    public void sendEmail() {
        MimeMessage message = new MimeMessage(mailSession);
        try {
            System.out.println("data::"+to+"::"+subject+"::"+body);
            message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body);

            Transport.send(message);
            System.out.println("done");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("mail sent", "mail to "+to+" sent successfully"));
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
