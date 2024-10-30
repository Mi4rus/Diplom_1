package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static praktikum.constants.Constants.*;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void getPriceTest() {
        float result = ingredient.getPrice();
        assertEquals(INGREDIENT_PRICE, result,DELTA);
    }

    @Test
    public void getNameTest() {
        String result = ingredient.getName();
        assertEquals(INGREDIENT_NAME, result);
    }

    @Test
    public void getTypeTest() {
        IngredientType result = ingredient.getType();
        assertEquals(IngredientType.FILLING, result);
    }
}