package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class SignupTest {

    private Signup signup;
    private Login login;
    private Settings settings;

    @BeforeEach
    void setup() {
        signup = new Signup(new Driver().getDriver());
        login = new Login(signup.getDriver());
        settings = new Settings(signup.getDriver());
    }

    @AfterEach
    void tearDown() {
        signup.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/signup_data.csv", numLinesToSkip = 1)
    void testSuccessfulSignup(String name, String userName, String email, String password, String expectedResult) {
        signup.signup(name, userName, email, password);
        if (expectedResult.equals("success")) {
            assertTrue(signup.validateSignup());
            login.fullLogin(userName, password);
            settings.deleteUser();
        } else if (expectedResult.equals("fail")) {
            assertTrue(signup.isInvalidSignup());
        }
    }
}
