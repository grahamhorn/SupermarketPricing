/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author gsh
 */
public class UnitItemTest {

    @Test
    public void testComputePrice() {
        UnitItem item = new UnitItem(1, "Baked Beans");
        PricesDatabase.getInstance().storePrice(1, 50);
        assertEquals(50, item.computePrice());

        PricesDatabase.getInstance().removePrice(1);
    }
}
