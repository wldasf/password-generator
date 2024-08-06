import org.example.PasswordManager;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordManagerTest {

    @Test
    public void givenAnEmptyString_whenGeneratePassword_thenExpectedResultIsReturned() {
        PasswordManager.generate();
        String password = PasswordManager.getPassword();
        assertEquals(8, password.length(), "Password length should be 8 characters");
    }

    @Test
    public void givenGeneratedPassword_whenAssertPasswordHasDigits_thenExpectedResultIsExpected() {
        PasswordManager.generate();
        String password = PasswordManager.getPassword();
        assertTrue(password.matches(".*\\d.*"), "Password should contain digits");
    }

    @Test
    public void givenGeneratedPassword_whenAssertPasswordHasUppercaseLetters_thenExpectedResultIsReturned() {
        PasswordManager.generate();
        String password = PasswordManager.getPassword();
        assertTrue(password.matches(".*[A-Z].*"), "Password should contain uppercase letters");
    }

    @Test
    public void givenGeneratePassword_whenPasswordContainsSymbols_thenExpectedResultIsReturned() {
        PasswordManager.generate();
        String password = PasswordManager.getPassword();
        assertTrue(password.matches(".*[_$#%].*"), "Password should contain symbols");
    }

    @Test
    public void givenTwoShuffledPasswords_whenBothPasswordAreCompared_thenExpectedResultIsReturned() {
        PasswordManager.generate();
        String password1 = PasswordManager.getPassword();
        PasswordManager.generate();
        String password2 = PasswordManager.getPassword();
        assertNotEquals(password1, password2, "Password should be shuffled");
    }
}
