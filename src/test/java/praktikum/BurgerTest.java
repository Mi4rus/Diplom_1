package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static praktikum.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp(){
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertTrue(burger.ingredients.isEmpty());
        burger.addIngredient(ingredient);

        assertEquals(1,burger.ingredients.size());
        assertEquals(burger.ingredients.get(0),ingredient);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        assertTrue(burger.ingredients.isEmpty());

        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.get(0),ingredient);

        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }


    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 2);

        assertEquals(burger.ingredients.get(1),ingredient2);
        assertEquals(burger.ingredients.get(2),ingredient1);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        List<Ingredient> ingredients = new ArrayList<>();

        for(int i =0; i<3;i++){
            ingredients.add(ingredient);
        }
        burger.ingredients=ingredients;
        burger.getPrice();
        float expectedPrice = BUN_PRICE * 2 + INGREDIENT_PRICE * ingredients.size();
        assertEquals(expectedPrice,burger.getPrice(),DELTA);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        burger.addIngredient(ingredient);
        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(),ingredient.getType().toString().toLowerCase(), ingredient.getName(), bun.getName(),burger.getPrice()
        );
        assertEquals(expectedReceipt, burger.getReceipt());
        }
    }




