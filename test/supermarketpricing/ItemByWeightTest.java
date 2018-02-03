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
public class ItemByWeightTest {

    @Test
    public void testComputePrice() {
        ItemByWeight item = new ItemByWeight(0, "Apples", 0.2f);

        PricesDatabase.getInstance().storePrice(0, 220);
        assertEquals(44, item.computePrice());

        PricesDatabase.getInstance().removePrice(0);
    }


}
