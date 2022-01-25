package uservalidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    UserValidator userValidator;
    User peter;
    User janos;

    @BeforeEach
    void init() {
        peter = new User(null, 33);
        janos = new User("János", 44);
        userValidator = new UserValidator(new ArrayList<>(Arrays.asList(janos)));
    }


    @Test
    void testUsersCreate() {
        assertEquals(2, userValidator.getUsers().size());
    }

    @Test
    void testUserListNull() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new UserValidator(Arrays.asList(null)));
        assertEquals("A Users lista nem lehet üres!", iae.getMessage());
    }

    @Test
    void testUserNull() {
        userValidator = new UserValidator(new ArrayList<>(Arrays.asList(peter)));
        userValidator.addUser(null);
        userValidator.validate();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> userValidator.addUser(null));
        assertEquals("A felhasználó sem lehet null!", iae.getMessage());
    }

    @Test
    void testUserNameNull() {

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> userValidator.addUser(peter));
        userValidator.validate();
        assertEquals("A felhasználó neve nem lehet üres!", iae.getMessage());
    }

    @Test
    void testUserAge120() {
        userValidator = new UserValidator(new ArrayList<>(Arrays.asList(peter)));
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> userValidator.addUser(new User("János", 122)));
        assertEquals("A felhasználó nem lehet ennyi idős!", iae.getMessage());
    }

    @Test
    void testUserAgeLessNull() {
        userValidator = new UserValidator(new ArrayList<>(Arrays.asList(peter)));
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> userValidator.addUser(new User("János", -1)));
        assertEquals("A felhasználó nem lehet ennyi idős!", iae.getMessage());
    }

}