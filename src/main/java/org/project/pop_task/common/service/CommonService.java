package org.project.pop_task.common.service;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        String phoneRegex = "^\\+?[1-9]\\d{1,14}$";
        return phoneNumber.matches(phoneRegex);
    }

    public String formatString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.trim().split("\\s+");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            formatted.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return formatted.toString().trim();
    }
}
