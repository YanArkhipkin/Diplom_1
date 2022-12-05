import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetBunNameParamTest {

    private final String bunName;
    private final String expectedName;

    public GetBunNameParamTest(String bunName, String expectedName) {
        this.bunName = bunName;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] nameTestData() {
        return new Object[][] {
                {" ", " "},
                {"белая", "белая"},
                {"серая", "серая"},
                {"булочка с кунжутом", "булочка с кунжутом"},
                {"bun name in english", "bun name in english"}
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(bunName, 24f);
        String actualName = bun.getName();
        assertEquals("Buns names is not equal", expectedName, actualName);
    }
}