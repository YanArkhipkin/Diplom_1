import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void addIngredientToBurgerTest(){
        burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertNotEquals(0, burger.ingredients.size());
    }

    @Test
    public void removeIngredientFromBurgerTest() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void moveBurgerIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
    }

    @Test
    public void getBurgerPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(12f);
        float actualPrice = burger.getPrice();
        assertEquals(32f, actualPrice, 0f);
    }

    @Test
    public void getBurgerReceiptTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("White bun", 12);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cutlet", 85);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        String expectedReceipt = "(==== White bun ====)\r\n= filling Cutlet =\r\n(==== White bun ====)\r\n\r\nPrice: 109,000000\r\n";
        String actualReceipt = burger.getReceipt();
        assertEquals("Receipts should be identical", expectedReceipt, actualReceipt);
    }

}
