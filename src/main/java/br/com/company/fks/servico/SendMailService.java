package br.com.company.fks.servico;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailService {
    private JavaMailSender javaMailSender;

    private static final Logger LOGGER = Logger.getLogger(SendMailService.class);

    @Autowired
    public SendMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarSimpleMeil(String destinatario, String assunto, String simpleText) throws MailException {
        // send email
        SimpleMailMessage mail = new SimpleMailMessage();
        // user
        mail.setTo(destinatario);
        mail.setSubject(assunto);
        mail.setText(simpleText);

        javaMailSender.send(mail);
    }

    public void enviarHtmlMail (String assunto, String htmlMsg, String destinatario) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            mimeMessage.setContent(htmlMsg, "text/html");
            helper.setTo(destinatario);
            helper.setSubject(assunto);
            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e) {
            LOGGER.error("ERRO AO ENVIAR EMAIL", e);
        }
    }


}
