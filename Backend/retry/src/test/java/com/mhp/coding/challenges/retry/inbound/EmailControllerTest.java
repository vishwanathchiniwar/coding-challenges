package com.mhp.coding.challenges.retry.inbound;

import com.mhp.coding.challenges.retry.core.entities.EmailNotification;
import com.mhp.coding.challenges.retry.core.inbound.NotificationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EmailControllerTest {

    @Mock
    NotificationHandler notificationHandler;

    @Mock
    EmailNotification mockEmailNotification;

    @InjectMocks
    private EmailController classUnderTest;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }


    @Test
    public void createEmailNotification_ok_CorrectResponse() {
        EmailNotification emailNotification = new EmailNotification("xyz@abc.com", "Test", "TestBody");
        when(this.notificationHandler.processEmailNotification(mockEmailNotification)).thenReturn(emailNotification);
        ResponseEntity<EmailNotification> response = this.classUnderTest.createEmailNotification(mockEmailNotification);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(emailNotification, response.getBody());
    }
}
