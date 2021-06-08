package com.mhp.coding.challenges.retry.core.persistence;

import com.mhp.coding.challenges.retry.core.entities.EmailRetry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRetryRepository extends MongoRepository<EmailRetry, Long> {

    List<EmailRetry> findByStatusIn(List<String> statusList);

}
