package praktikum;

import org.apache.http.io.SessionOutputBuffer;
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
    private Ingredient ingredient;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

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
        ingredient = new Ingredient(IngredientType.FILLING,INGREDIENT_NAME, INGREDIENT_PRICE);

        assertTrue(burger.ingredients.isEmpty());

        burger.addIngredient(ingredient);
        assertEquals(1,burger.ingredients.size());
        assertEquals(burger.ingredients.get(0),ingredient);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        ingredient = new Ingredient(IngredientType.FILLING,INGREDIENT_NAME, INGREDIENT_PRICE);
        assertTrue(burger.ingredients.isEmpty());

        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.get(0),ingredient);

        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }


    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();

        ingredient1 = new Ingredient(IngredientType.SAUCE,INGREDIENT_NAME, INGREDIENT_PRICE);
        ingredient2 = new Ingredient(IngredientType.SAUCE,INGREDIENT_NAME, INGREDIENT_PRICE);
        ingredient3 = new Ingredient(IngredientType.FILLING,INGREDIENT_NAME, INGREDIENT_PRICE);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1, 2);

        assertEquals(burger.ingredients.get(1),ingredient3);
        assertEquals(burger.ingredients.get(2),ingredient2);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        ingredient = new Ingredient(IngredientType.SAUCE,INGREDIENT_NAME, INGREDIENT_PRICE);
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
        bun = new Bun(BUN_NAME,BUN_PRICE);
        burger.setBuns(bun);
        ingredient = new Ingredient(IngredientType.SAUCE,INGREDIENT_NAME, INGREDIENT_PRICE);
        burger.addIngredient(ingredient);
        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(),ingredient.getType().toString().toLowerCase(), ingredient.getName(), bun.getName(),burger.getPrice()
        );
        System.out.println(burger.getReceipt());
        System.out.println(expectedReceipt);

        assertEquals(expectedReceipt, burger.getReceipt());
        }
    }




