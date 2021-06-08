package com.mhp.coding.challenges.retry.core.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class RetryBuilderService {

    @Value("${retry.initialinterval}")
    private int initialInterval;

    @Value("${retry.multiplier}")
    private int multiplier;

    @Value("${retry.maxinterval}")
    private int maxInterval;

    /**
     * RetryTemplate to create the retry based on the required attempts, delay ..etc
     *
     * @param attempts Number of retry attempts
     * @return retryTemplate
     */
    public RetryTemplate setRetryBuilder(int attempts) {
        return RetryTemplate.builder()
                .maxAttempts(attempts)
                .exponentialBackoff(initialInterval, multiplier, maxInterval)
                .retryOn(RuntimeException.class)
                .traversingCauses()
                .build();
    }
}
