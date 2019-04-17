package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;



public class TestLogin {
    private Login login;

    @BeforeEach
    void setLogin() {
        login = new Login(new Driver().getDriver());
    }

    @AfterEach
    void closeDriver(){
        login.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/valid_login.csv", numLinesToSkip = 1)
     void loginSuccesful(String username, String password, String expectedresult){
        login.fullLogin(username, password);
        assertEquals(expectedresult, login.getUsername());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalid_login.csv", numLinesToSkip = 1)
     void loginFailure(String username, String password){
        login.fullLogin(username,password);
        assertEquals(login.getURL(), login.LOGIN_URL);
    }
}
