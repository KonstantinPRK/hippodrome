import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class HippodromeMethodsTest {
    //список из 30 разных лошадей
    List<Horse> horses = List.of(
            //10
            new Horse("Bucephalus", 1.0),
            new Horse("Ace of Spades", 1.1),
            new Horse("Zephyr", 1.2),
            new Horse("Blaze", 1.3),
            new Horse("Lobster", 1.4),
            new Horse("Pegasus", 1.5),
            new Horse("Cherry", 1.6),
            new Horse("Not Cherry", 1.7),
            new Horse("Apple", 1.8),
            new Horse("Fruit", 1.9),

            //20
            new Horse("Second Bucephalus", 2.0),
            new Horse("Second Ace of Spades", 2.1),
            new Horse("Second Zephyr", 2.2),
            new Horse("Second Blaze", 2.3),
            new Horse("Second Lobster", 2.4),
            new Horse("Second Pegasus", 2.5),
            new Horse("Second Cherry", 2.6),
            new Horse("Second Not Cherry", 2.7),
            new Horse("Second Apple", 2.8),
            new Horse("Second Fruit", 2.9),

            //30
            new Horse("Third Bucephalus", 3.0),
            new Horse("Third Ace of Spades", 3.1),
            new Horse("Third Zephyr", 3.2),
            new Horse("Third Blaze", 3.3),
            new Horse("Third Lobster", 3.4),
            new Horse("Third Pegasus", 3.5),
            new Horse("Third Cherry", 3.6),
            new Horse("Third Not Cherry", 3.7),
            new Horse("Third Apple", 3.8),
            new Horse("Third Fruit", 3.9)
    );


    //возвращает список, который содержит те же объекты и в той же последовательности
    @Test
    public void getHorses() {
        Hippodrome allHorses = new Hippodrome(horses);
        assertEquals(horses, allHorses.getHorses());
    }


    //вызывает метод move у всех лошадей
    @Test
    public void move() {
        List<Horse> mockHorses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Horse mockHorse = Mockito.mock(Horse.class);
            mockHorses.add(mockHorse);
        }

        Hippodrome allHorses = new Hippodrome(mockHorses);
        allHorses.move();

        for (Horse horse : mockHorses) {
            Mockito.verify(horse).move();
        }

    }

    //метод возвращает лошадь с самым большим значением distance
    @Test
    public void getWinner() {
        Hippodrome allHorses = new Hippodrome(horses);

        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            mockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(1.0);

            //Проверка вызова метода
            for (Horse horse : allHorses.getHorses()) {
                horse.move();
            }

            Horse winner = allHorses.getWinner();


            assertEquals("Third Fruit", winner.getName());
        }

    }

}

