import com.codecool.Driver;
import com.codecool.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


import javax.annotation.Resource;

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
    @CsvFileSource(resources = "valid_login.csv", numLinesToSkip = 1)
    public void loginSuccesful(String username, String password, String expectedresult){
        login.openLoginPage();
        login.fullLogin(username, password);
        assertEquals(expectedresult, login.getUsername());
    }
}
