import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {

    private final IngredientType ingredientType;
    private final IngredientType expectedType;

    public IngredientTypeParamTest(IngredientType ingredientType, IngredientType expectedType) {
        this.ingredientType = ingredientType;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTypeTestData() {
        return new Object[][] {
                {FILLING, FILLING},
                {SAUCE, SAUCE}
        };
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "Beef cutlet", 100f);
        IngredientType actualType = ingredient.getType();
        assertEquals("Ingredients types should be equal", expectedType, actualType);
    }
}