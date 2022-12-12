import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientPriceParamTest {

    private final float ingredientPrice;
    private final float expectedPrice;

    public IngredientPriceParamTest(float ingredientPrice, float expectedPrice) {
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] priceTestData() {
        return new Object[][] {
                {20f, 20f},
                {564565645f, 564565645f},
                {0f, 0f},
                {8f, 8f}
        };
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "Cheese sauce", ingredientPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Ingredients prices should be equal", expectedPrice, actualPrice, 0f);
    }
}
