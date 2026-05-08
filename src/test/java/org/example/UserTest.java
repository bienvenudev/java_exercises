package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    static class TestData {
        String username;
        String password;
        boolean expectedValidUsername;
        boolean expectedStrongPassword;
        boolean expectedValid;

        public TestData(String username, String password, boolean expectedValidUsername, boolean expectedStrongPassword, boolean expectedValid) {
            this.username = username;
            this.password = password;
            this.expectedValidUsername = expectedValidUsername;
            this.expectedStrongPassword = expectedStrongPassword;
            this.expectedValid = expectedValid;
        }
    }

    static TestData[] testData;
    static int index = 0;

    @BeforeAll
    static void setUp() {
        testData = new TestData[] {
                new TestData("Alice", "12345678", true, true, true),
                new TestData("Alice", "123", true, false, false),
                new TestData("Alice", null, true, false, false),
                new TestData("", "12345678", false, true, false),
                new TestData(null, "12345678", false, true, false),
                new TestData("    ", "12345678", false, true, false),
        };
    }

    @BeforeEach
    void createUser() {
        User user = new User(testData[index].username, testData[index].password);
        // You might need to set this user to a field if you need to access it in your test methods
    }

    @RepeatedTest(value = 6, name = "user test {currentRepetition}/{totalRepetitions}")
    void testUser() {
        TestData data = testData[index];
        User user = new User(data.username, data.password);
        boolean isValidUsername = user.hasValidUsername();
        boolean hasStrongPassword = user.hasStrongPassword();
        boolean isValid = user.isValid();

        assertEquals(data.expectedValidUsername, isValidUsername);
        assertEquals(data.expectedStrongPassword, hasStrongPassword);
        assertEquals(data.expectedValid, isValid);

        index++;
    }

    @AfterAll
    static void tearDown() {
        index = 0;
    }
}