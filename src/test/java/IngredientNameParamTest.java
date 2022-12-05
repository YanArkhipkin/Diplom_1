import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class IngredientNameParamTest {

    private final String ingredientName;
    private final String expectedName;

    public IngredientNameParamTest(String ingredientName, String expectedName) {
        this.ingredientName = ingredientName;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] nameTestData() {
        return new Object[][] {
                {"Говяжья котлета", "Говяжья котлета"},
                {"Onion", "Onion"},
                {"Петрушка", "Петрушка"},
                {" ", " "}
        };
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(FILLING, ingredientName, 12f);
        String actualName = ingredient.getName();
        assertEquals("Ingredients names should be equal", expectedName, actualName);
    }
}
