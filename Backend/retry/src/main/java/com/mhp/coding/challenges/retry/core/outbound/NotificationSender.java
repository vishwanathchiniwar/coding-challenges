package com.mhp.coding.challenges.retry.core.outbound;

import com.mhp.coding.challenges.retry.core.entities.EmailRetry;

public interface NotificationSender {

    void sendEmail(EmailRetry emailRetry);
}
