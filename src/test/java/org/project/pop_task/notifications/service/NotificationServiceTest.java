package org.project.pop_task.notifications.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.pop_task.notifications.model.NotificationRequest;
import org.project.pop_task.notifications.model.NotificationResponse;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    private NotificationService notificationService;

    @BeforeEach
    void setup() {
        notificationService = new NotificationService();
    }

    @Test
    void testSendEmailSuccess() {
        NotificationRequest request = new NotificationRequest("user@example.com", "Welcome to WolfDesk!");

        NotificationResponse response = notificationService.sendEmail(request);

        assertTrue(response.isSuccess());
        assertEquals("Email sent successfully to user@example.com", response.getMessage());
    }

    @Test
    void testSendEmailFailure() {
        NotificationRequest request = new NotificationRequest(null, "Welcome to WolfDesk!");

        NotificationResponse response = notificationService.sendEmail(request);

        assertFalse(response.isSuccess());
        assertEquals("Recipient or message cannot be null.", response.getMessage());
    }

    @Test
    void testSendSMSSuccess() {
        NotificationRequest request = new NotificationRequest("+1234567890", "Your ticket has been updated!");

        NotificationResponse response = notificationService.sendSMS(request);

        assertTrue(response.isSuccess());
        assertEquals("SMS sent successfully to +1234567890", response.getMessage());
    }

    @Test
    void testSendSMSFailure() {
        NotificationRequest request = new NotificationRequest("+1234567890", null);

        NotificationResponse response = notificationService.sendSMS(request);

        assertFalse(response.isSuccess());
        assertEquals("Recipient or message cannot be null.", response.getMessage());
    }

    @Test
    void testSendPushNotificationSuccess() {
        NotificationRequest request = new NotificationRequest("device123", "You have a new message!");

        NotificationResponse response = notificationService.sendPushNotification(request);

        assertTrue(response.isSuccess());
        assertEquals("Push notification sent successfully to device123", response.getMessage());
    }

    @Test
    void testSendPushNotificationFailure() {
        NotificationRequest request = new NotificationRequest(null, "You have a new message!");

        NotificationResponse response = notificationService.sendPushNotification(request);

        assertFalse(response.isSuccess());
        assertEquals("Recipient or message cannot be null.", response.getMessage());
    }
}
