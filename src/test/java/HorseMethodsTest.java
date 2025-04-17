import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class HorseMethodsTest {
    public String NormalName = "Name";
    public double NormalSpeed = 1.0;
    public double NormalDistance = 2.0;

    @Test
    public void getName() {
        Horse animal = new Horse(NormalName, NormalSpeed, NormalDistance);

        assertEquals(NormalName, animal.getName());
    }

    @Test
    public void getSpeed() {
        Horse animal = new Horse(NormalName, NormalSpeed, NormalDistance);

        assertEquals(NormalSpeed, animal.getSpeed());
    }

    @Test
    public void getDistance() {
        //метод возвращает число, которое было передано третьим параметром в конструктор
        Horse firstAnimal = new Horse(NormalName, NormalSpeed, NormalDistance);
        assertEquals(NormalDistance, firstAnimal.getDistance());

        //метод возвращает ноль, если объект был создан с помощью конструктора с двумя параметрами
        Horse secondAnimal = new Horse(NormalName, NormalSpeed);
        assertEquals(0, secondAnimal.getDistance());
    }


    @ParameterizedTest
    @CsvSource({
            "0.2, 5.0",
            "0.9, 10.0",
            "0.5, 7.0"
    })
    public void move(double mockedRandom, double speed) {
        // Начальное значение дистанции
        double initialDistance = 100.0;

        Horse horse = new Horse(NormalName, speed, initialDistance);

        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            mockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(mockedRandom);

            //Проверка вызова метода
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));

            double expectedDistance = initialDistance + speed * mockedRandom;
            assertEquals(expectedDistance, horse.getDistance(), 0.0001);
        }

    }
}
