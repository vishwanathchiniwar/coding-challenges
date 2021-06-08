package com.mhp.coding.challenges.retry.core.logic;

import com.mhp.coding.challenges.retry.core.entities.EmailRetry;
import com.mhp.coding.challenges.retry.core.enums.Status;
import com.mhp.coding.challenges.retry.core.outbound.NotificationSender;
import com.mhp.coding.challenges.retry.core.persistence.EmailRetryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecoveryService {

    private static final Logger logger = LoggerFactory.getLogger(RecoveryService.class);

    @Autowired
    EmailRetryRepository emailRetryRepository;

    @Autowired
    private NotificationSender notificationSender;

    @Autowired
    private RetryBuilderService retryBuilderService;

    private static final Integer MAX_ATTEMPTS = 6;

    /**
     * Scheduler runs every 5th minute to send the failed Email delivery
     */
    @Scheduled(cron = "${cron.expression}")
    public void remainingRetry() {
        logger.info("Checking for the failed Email delivery..");
        List<String> statusList = List.of(Status.FAILED.toString(), Status.PENDING.toString(), Status.RETRY.toString());
        List<EmailRetry> emailRetriesList = emailRetryRepository.findByStatusIn(statusList);

        emailRetriesList.stream().forEach(emailRetry -> {
            if (emailRetry.getCount() < MAX_ATTEMPTS) {
                retryBuilderService.setRetryBuilder(MAX_ATTEMPTS - emailRetry.getCount()).execute(
                        context -> {
                            notificationSender.sendEmail(emailRetry);
                            return true;
                        });
            }
        });
    }
}
