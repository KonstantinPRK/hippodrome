import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseCreateObjectTest {
    //Нормальные параметры
    public String NormalName = "Name";
    public double NormalSpeed = 1.0;
    public double NormalDistance = 2.0;


    //первым параметром null, будет выброшено IllegalArgumentException
    @Test
    public void ifNullEx() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, NormalSpeed, NormalDistance));
    }

    //первым параметром null, выброшенное исключение будет содержать сообщение "Name cannot be null."
    @Test
    public void ifNullGetWarningMessageEx() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> new Horse(null, NormalSpeed, NormalDistance));

        assertEquals("Name cannot be null.", exception.getMessage());
    }


    //первым параметром пустая строка или пробельные символы - будет выброшено IllegalArgumentException
    @Test
    public void ifEmptyStringEx() {
        //Пустая строка
        assertThrows(IllegalArgumentException.class,
                () -> new Horse("", NormalSpeed, NormalDistance));

        //Пробел
        assertThrows(IllegalArgumentException.class,
                () -> new Horse("  ", NormalSpeed, NormalDistance));
    }

    //первым параметром пустая строка или пробельные символы - исключение будет содержать сообщение "Name cannot be blank."
    @Test
    public void ifEmptyStringGetWarningMessageEx() {
        //Пустая строка
        IllegalArgumentException emptyException = assertThrows(IllegalArgumentException.class,
                () -> new Horse("", NormalSpeed, NormalDistance));

        assertEquals("Name cannot be blank.", emptyException.getMessage());

        //Пробел
        IllegalArgumentException spaceException = assertThrows(IllegalArgumentException.class,
                () -> new Horse("  ", NormalSpeed, NormalDistance));

        assertEquals("Name cannot be blank.", spaceException.getMessage());
    }


    //вторым параметром отрицательного числа, будет выброшено IllegalArgumentException
    @Test
    public void ifNegativeSecondFigureEx() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(NormalName, -2, NormalDistance));
    }

    //вторым параметром отрицательного числа, выброшенное исключение будет содержать сообщение "Speed cannot be negative."
    @Test
    public void ifNegativeSecondFigureGetWarningMessageEx() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(NormalName, -2, NormalDistance));

        assertEquals("Speed cannot be negative.", exception.getMessage());
    }


    //третьим параметром отрицательного числа, будет выброшено IllegalArgumentException
    @Test
    public void ifNegativeThirdFigureEx() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(NormalName, NormalSpeed, -3));
    }

    //третьим параметром отрицательного числа, выброшенное исключение будет содержать сообщение "Distance cannot be negative."
    @Test
    public void ifNegativeThirdFigureGetWarningMessageEx() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(NormalName, NormalSpeed, -3));

        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

}
