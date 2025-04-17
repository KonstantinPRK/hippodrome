import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HippodromeCreateObjectTest {
    public List<Horse> emptyList = new ArrayList<>();

    //при передаче в конструктор null, будет выброшено IllegalArgumentException
    @Test
    public void ifNullEx() {
        assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));
    }

    //при передаче в конструктор null, выброшенное исключение будет содержать сообщение "Horses cannot be null."
    @Test
    public void ifNullGetWarningMessageEx() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));

        assertEquals("Horses cannot be null.", exception.getMessage());
    }


    //при передаче в конструктор пустого списка, будет выброшено IllegalArgumentException
    @Test
    public void ifEmptyListEx() {
        assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(emptyList));
    }

    //при передаче в конструктор пустого списка, выброшенное исключение будет содержать сообщение "Horses cannot be empty."
    @Test
    public void ifEmptyListGetWarningMessageEx() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(emptyList));

        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

}
