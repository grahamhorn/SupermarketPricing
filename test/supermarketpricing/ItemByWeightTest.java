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
        PricedItem pricedItem = item.computePrice();
        assertEquals(44, pricedItem.getPrice());
        assertEquals("Apples\n0.2kg @ £2.20/kg", pricedItem.getDescription());

        PricesDatabase.getInstance().removePrice(0);
    }


}
