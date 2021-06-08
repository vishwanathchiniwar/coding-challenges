package com.mhp.coding.challenges.retry.outbound;

import com.mhp.coding.challenges.retry.core.entities.EmailRetry;
import com.mhp.coding.challenges.retry.core.enums.Status;
import com.mhp.coding.challenges.retry.core.outbound.NotificationSender;
import com.mhp.coding.challenges.retry.core.persistence.EmailRetryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EmailNotificationSenderService implements NotificationSender {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationSenderService.class);

    @Autowired
    private EmailRetryRepository emailRetryRepository;

    private static final String SENDER_ADDRESS = "info@mhp.com";

    private JavaMailSender mailSender;

    public EmailNotificationSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailRetry emailRetry) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(SENDER_ADDRESS);
            mailMessage.setTo(emailRetry.getEmailNotification().getRecipient());
            mailMessage.setSubject(emailRetry.getEmailNotification().getSubject());
            mailMessage.setText(emailRetry.getEmailNotification().getText());
            saveEmailBeforeSending(emailRetry);
            mailSender.send(mailMessage);
            logger.info("The email has sent successfully");
            emailRetryRepository.delete(emailRetry);
        }
        catch (Exception e) {
            emailRetry.setStatus(Status.FAILED);
            emailRetryRepository.save(emailRetry);
            throw new RuntimeException(
                    String.format("Failed to send email to recipient: %s",
                            emailRetry.getEmailNotification().getRecipient()));
        }
    }

    private void saveEmailBeforeSending(EmailRetry emailRetry) {
        int retryCount = emailRetry.getCount();
        retryCount++;
        emailRetry.setCount(retryCount);
        emailRetry.setStatus(Status.RETRY);
        emailRetryRepository.save(emailRetry);
    }
}
