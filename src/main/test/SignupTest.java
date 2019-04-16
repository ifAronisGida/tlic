import com.codecool.Driver;
import com.codecool.Signup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class SignupTest {

    private Signup signup;

    @BeforeEach
    void setup() {
        signup = new Signup(new Driver().getDriver());
    }

    @AfterEach
    void tearDown() {
        signup.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/signup_data.csv", numLinesToSkip = 1)
    void testSuccessfulSignup(String name, String userName, String email, String password) {
        signup.signup(name, userName, email, password);
        assertTrue(signup.validateSignup());

    }
}
