package com.mhp.coding.challenges.retry.core.logic;

import com.mhp.coding.challenges.retry.core.entities.EmailNotification;
import com.mhp.coding.challenges.retry.core.entities.EmailRetry;
import com.mhp.coding.challenges.retry.core.enums.Status;
import com.mhp.coding.challenges.retry.core.inbound.NotificationHandler;
import com.mhp.coding.challenges.retry.core.outbound.NotificationSender;
import com.mhp.coding.challenges.retry.core.persistence.EmailRetryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class NotificationService implements NotificationHandler {

    @Autowired
    private EmailRetryRepository emailRetryRepository;

    @Autowired
    private RetryBuilderService retryBuilderService;

    private NotificationSender notificationSender;

    private EmailRetry emailRetry;

    private static final Integer NUMBER_OF_ATTEMPTS = 5;

    public NotificationService(NotificationSender notificationSender, EmailRetry emailRetry) {
        this.notificationSender = notificationSender;
        this.emailRetry = emailRetry;
    }

    @Override
    public EmailNotification processEmailNotification(EmailNotification emailNotification) {
        emailRetry = new EmailRetry(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli(), Status.PENDING, 1,
                emailNotification);
        emailRetryRepository.insert(emailRetry);
        retryBuilderService.setRetryBuilder(NUMBER_OF_ATTEMPTS).execute(
                context -> {
                    notificationSender.sendEmail(emailRetry);
                    return true;
                });
        return emailNotification;
    }
}
