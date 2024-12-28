package org.project.pop_task.notifications.service;

import org.project.pop_task.notifications.model.NotificationRequest;
import org.project.pop_task.notifications.model.NotificationResponse;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public NotificationResponse sendEmail(NotificationRequest request) {
        if (request.getRecipient() == null || request.getMessage() == null) {
            return new NotificationResponse(false, "Recipient or message cannot be null.");
        }
        return new NotificationResponse(true, "Email sent successfully to " + request.getRecipient());
    }

    public NotificationResponse sendSMS(NotificationRequest request) {
        if (request.getRecipient() == null || request.getMessage() == null) {
            return new NotificationResponse(false, "Recipient or message cannot be null.");
        }
        return new NotificationResponse(true, "SMS sent successfully to " + request.getRecipient());
    }

    public NotificationResponse sendPushNotification(NotificationRequest request) {
        if (request.getRecipient() == null || request.getMessage() == null) {
            return new NotificationResponse(false, "Recipient or message cannot be null.");
        }
        return new NotificationResponse(true, "Push notification sent successfully to " + request.getRecipient());
    }
}
