package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static praktikum.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(BUN_NAME,BUN_PRICE);
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();


    }

    @Test
    public void addIngredientTest() {
    }

    @Test
    public void removeIngredientTest() {
    }

    @Test
    public void moveIngredientTest() {
    }

    @Test
    public void getPriceTest() {
    }

    @Test
    public void getReceipt() {
    }
}