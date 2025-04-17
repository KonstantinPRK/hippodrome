import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    @Disabled
    public void timeTest() throws Exception {
        long startTime = System.currentTimeMillis();
        Main.main();
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        boolean lessThan22sec = (timeElapsed / 1000) < 22;

        assertTrue(lessThan22sec);
    }

}
