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
        OffersDatabase.getInstance().clear();
        Receipt receipt = basket.calculate();

        assertEquals(50 * 3 + 70 * 2 + 40, receipt.getSubtotal());
        assertEquals(50 * 3 + 70 * 2 + 40, receipt.getTotal());

        System.out.println(receipt.toString());

    }

    @Test
    public void testBasketWithOffers() {
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

        OffersDatabase.getInstance().addOffer(10, new OfferNForM(10, "Beans 3 for 2", 3, 2));
        OffersDatabase.getInstance().addOffer(20, new OfferNForX(20, "Coke 2 for £1", 2, 100));

        Receipt receipt = basket.calculate();

        assertEquals(50 * 3 + 70 * 2 + 40, receipt.getSubtotal());
        assertEquals(50 * 3 + 70 * 2 + 40 - 50 - 40, receipt.getTotal());

        System.out.println(receipt.toString());

    }
}
