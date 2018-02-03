/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gsh
 */
public class BasketTest {

    @Test
    public void testBasketNoOffers() {
        Basket basket = new Basket();
        basket.addItem(new UnitItem(10, "Beans"));
        basket.addItem(new UnitItem(10, "Beans"));
        basket.addItem(new UnitItem(10, "Beans"));
        basket.addItem(new UnitItem(20, "Coke"));
        basket.addItem(new UnitItem(20, "Coke"));
        basket.addItem(new ItemByWeight(100, "Oranges", 0.2f));


        PricesDatabase.getInstance().storePrice(10, 50);
        PricesDatabase.getInstance().storePrice(20, 70);
        PricesDatabase.getInstance().storePrice(100, 199);
        Receipt receipt = basket.calculate();

        assertEquals(50 * 3 + 70 * 2 + 40, receipt.getSubtotal());
        assertEquals(50 * 3 + 70 * 2 + 40, receipt.getTotal());

        System.out.println(receipt.toString());

    }
}
