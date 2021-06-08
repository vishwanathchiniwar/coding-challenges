package com.mhp.coding.challenges.retry.configuration;

import com.mhp.coding.challenges.retry.core.entities.EmailRetry;
import com.mhp.coding.challenges.retry.core.inbound.NotificationHandler;
import com.mhp.coding.challenges.retry.core.logic.NotificationService;
import com.mhp.coding.challenges.retry.core.outbound.NotificationSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalBeanConfiguration {

    @Bean
    public NotificationHandler notificationHandler(NotificationSender notificationSender, EmailRetry emailRetry) {
        return new NotificationService(notificationSender, emailRetry);
    }
}
