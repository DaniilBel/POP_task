package org.project.pop_task.common.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonServiceTest {

    private CommonService commonService;

    @BeforeEach
    void setup() {
        commonService = new CommonService();
    }

    @Test
    void testIsValidEmailValid() {
        assertTrue(commonService.isValidEmail("user@example.com"));
        assertFalse(commonService.isValidEmail("user.name+tag@sub.example.co.uk"));
    }

    @Test
    void testIsValidEmailInvalid() {
        assertFalse(commonService.isValidEmail(null));
        assertFalse(commonService.isValidEmail(""));
        assertFalse(commonService.isValidEmail("invalid-email"));
        assertFalse(commonService.isValidEmail("user@.com"));
    }

    @Test
    void testIsValidPhoneNumberValid() {
        assertTrue(commonService.isValidPhoneNumber("+1234567890"));
        assertTrue(commonService.isValidPhoneNumber("1234567890"));
    }

    @Test
    void testIsValidPhoneNumberInvalid() {
        assertFalse(commonService.isValidPhoneNumber(null));
        assertFalse(commonService.isValidPhoneNumber(""));
        assertFalse(commonService.isValidPhoneNumber("abc123"));
        assertFalse(commonService.isValidPhoneNumber("+1-800-555-5555"));
    }

    @Test
    void testFormatStringValid() {
        assertEquals("Hello World", commonService.formatString("hello world"));
        assertEquals("Wolfdesk System", commonService.formatString("wolfdesk SYSTEM"));
    }

    @Test
    void testFormatStringEdgeCases() {
        assertEquals("", commonService.formatString(""));
        assertNull(commonService.formatString(null));
        assertEquals("Single", commonService.formatString("single"));
        assertEquals("Multiple Words Example", commonService.formatString("  multiple words   example   "));
    }
}
