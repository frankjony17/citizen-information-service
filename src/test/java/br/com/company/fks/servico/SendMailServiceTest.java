package br.com.company.fks.servico;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SendMailServiceTest {

    @InjectMocks
    private SendMailService sendMailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private MimeMessage mimeMessage;

    @Test
    public void SendMailService(){
        javaMailSender.getClass();
    }

    @Test
    public void enviarSimpleMeil() throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("destinatario");
        mail.setSubject("assunto");
        mail.setText("simpleText");
        sendMailService.enviarSimpleMeil("des","ass","simT");
    }

    @Test
    public void enviarHtmlMail() throws IOException, MessagingException {
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        when(mimeMessage.getContent()).thenReturn(Object.class);
        sendMailService.enviarHtmlMail("assunto", "htmlMsg", "destinatario");
    }

    @Test
    public void enviarHtmlMailException() throws IOException, MessagingException {
        when(javaMailSender.createMimeMessage()).thenThrow(MessagingException.class);
        when(mimeMessage.getContent()).thenReturn(Object.class);
        sendMailService.enviarHtmlMail("assunto", "htmlMsg", "destinatario");
    }

}