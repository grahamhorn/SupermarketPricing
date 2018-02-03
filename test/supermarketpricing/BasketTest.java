/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gsh
 */
public class BasketTest {

    // TODO All of the UnitItem instances could be constants
    // and could be generated using a Factory to ensure the id is unique.
    private static final UnitItem BEANS = new UnitItem(10, "Beans");

    @After
    public void tearDown() {
        PricesDatabase.getInstance().clear();
        OffersDatabase.getInstance().clear();
    }

    @Test
    public void testBasketNoOffers() {
        Basket basket = new Basket();
        basket.addItem(BEANS);
        basket.addItem(BEANS);
        basket.addItem(BEANS);
        basket.addItem(new UnitItem(20, "Coke"));
        basket.addItem(new UnitItem(20, "Coke"));
        basket.addItem(new ItemByWeight(100, "Oranges", 0.2f));

        PricesDatabase.getInstance().storePrice(10, 50);
        PricesDatabase.getInstance().storePrice(20, 70);
        PricesDatabase.getInstance().storePrice(100, 199);

        Receipt receipt = basket.calculate();

        assertEquals(50 * 3 + 70 * 2 + 40, receipt.getSubtotal());
        assertEquals(50 * 3 + 70 * 2 + 40, receipt.getTotal());
        assertEquals(6, receipt.getItems().size());
        System.out.println(receipt.toString());

    }

    @Test
    public void testBasketWithOffers() {
        Basket basket = new Basket();
        basket.addItem(BEANS);
        basket.addItem(BEANS);
        basket.addItem(BEANS);
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
        assertEquals(6, receipt.getItems().size());
        System.out.println(receipt.toString());

    }

    @Test
    public void testBasketWithBeerOffers() {
        PricesDatabase.getInstance().storePrice(10, 50);
        PricesDatabase.getInstance().storePrice(20, 70);
        PricesDatabase.getInstance().storePrice(100, 199);
        PricesDatabase.getInstance().storePrice(401, 199);
        PricesDatabase.getInstance().storePrice(402, 185);
        PricesDatabase.getInstance().storePrice(403, 180);
        PricesDatabase.getInstance().storePrice(404, 185);

        OffersDatabase.getInstance().addOffer(10, new OfferNForM(10, "Beans 3 for 2", 3, 2));
        OffersDatabase.getInstance().addOffer(20, new OfferNForX(20, "Coke 2 for £1", 2, 100));
        Set<Integer> beerIds = new HashSet<>();
        beerIds.add(401);
        beerIds.add(402);
        beerIds.add(403);
        Offer beerOffer = new OfferNFromSetForX(beerIds, "3 Ales for £5", 3, 500);
        OffersDatabase.getInstance().addOffer(401, beerOffer);
        OffersDatabase.getInstance().addOffer(402, beerOffer);
        OffersDatabase.getInstance().addOffer(403, beerOffer);

        Basket basket = new Basket();
        basket.addItem(BEANS);
        basket.addItem(BEANS);
        basket.addItem(BEANS);
        basket.addItem(new UnitItem(20, "Coke"));
        basket.addItem(new UnitItem(20, "Coke"));
        basket.addItem(new ItemByWeight(100, "Oranges", 0.2f));
        basket.addItem(new UnitItem(401, "Stout"));
        basket.addItem(new UnitItem(402, "IPA"));
        basket.addItem(new UnitItem(401, "Stout"));
        basket.addItem(new UnitItem(403, "Porter"));
        basket.addItem(BEANS);


        Receipt receipt = basket.calculate();

        System.out.println(receipt.toString());

        int cokeSaving = 40;
        int beansSaving = 50;
        int beerSaving = 199 + 185 + 180 - 500; // cheapest 3 beers
        assertEquals(50 * 4 + 70 * 2 + 40 + 2 * 199 + 185 + 180, receipt.getSubtotal());
        assertEquals(50 * 4 + 70 * 2 + 40 + 2 * 199 + 185 + 180 - beansSaving - cokeSaving - beerSaving, receipt.getTotal());

        assertEquals(11, receipt.getItems().size());

    }
}
