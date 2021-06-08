package com.mhp.coding.challenges.retry.core.entities;

import com.mhp.coding.challenges.retry.core.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * Entity class to store Email delivery details
 */
@Data
@Document
@Component
@AllArgsConstructor
@NoArgsConstructor
public class EmailRetry {

    @Id
    private long id;

    private Status status;

    private int count;

    private EmailNotification emailNotification;

}
