package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static praktikum.constants.Constants.*;
import static org.junit.Assert.assertEquals;

public class BunTest {

   private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME,BUN_PRICE);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getNameTest() {
       String result = bun.getName();
       assertEquals(BUN_NAME, result);
    }

    @Test
    public void getPriceTest() {
        float result = bun.getPrice();
        assertEquals(BUN_PRICE, result, DELTA);
    }
}