package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Constants.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType type, String name, float price) {
        this.expectedType = type;
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { SAUCE, "Имя1", 0.5f },
                { FILLING, "Имя2", 0.7f },
                { FILLING, "Имя3", 1.5f },
                { SAUCE, "Имя4", 0.8f },
                { IngredientType.SAUCE, "Имя5", 0.3f }
        });
    }

    @Test
    public void getTypeTest() {
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(expectedPrice, ingredient.getPrice(), DELTA);
    }
}