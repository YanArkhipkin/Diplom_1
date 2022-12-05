import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetBunPriceParamTest {

    private final float bunPrice;
    private final float expectedPrice;

    public GetBunPriceParamTest(float bunPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] priceTestData() {
        return new Object[][] {
                {15f, 15f},
                {22f, 22f},
                {0f, 0f},
                {5646556564564f, 5646556564564f}
        };
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun("Тестовая булочка", bunPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Buns prices is not equals", expectedPrice, actualPrice, 0f);
    }
}