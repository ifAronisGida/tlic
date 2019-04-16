import com.codecool.Driver;
import com.codecool.Signup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
}
