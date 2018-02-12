/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gsh
 */
public class OfferNForMTest {


    @Test
    public void testComputeSaving() {
        int unitPrice = 50;
        OfferNForM offer = new OfferNForM(10, "Beans 3 For 2", 3, 2);

        OfferSaving saving = offer.computeSaving(1, unitPrice);
        assertEquals(0, saving.getSaving());

        saving = offer.computeSaving(2, unitPrice);
        assertEquals(0, saving.getSaving());

        saving = offer.computeSaving(3, unitPrice);
        assertEquals(-50, saving.getSaving());

        saving = offer.computeSaving(4, unitPrice);
        assertEquals(-50, saving.getSaving());

        saving = offer.computeSaving(5, unitPrice);
        assertEquals(-50, saving.getSaving());

        saving = offer.computeSaving(6, unitPrice);
        assertEquals(-100, saving.getSaving());
    }

    @Test
    public void testComputeSaving4For2() {
        int unitPrice = 50;
        OfferNForM offer = new OfferNForM(10, "Beans 4 For 2", 4, 2);
        OfferSaving saving = offer.computeSaving(1, unitPrice);
        assertEquals(0, saving.getSaving());

        saving = offer.computeSaving(2, unitPrice);
        assertEquals(0, saving.getSaving());

        saving = offer.computeSaving(3, unitPrice);
        assertEquals(0, saving.getSaving());

        saving = offer.computeSaving(4, unitPrice);
        assertEquals(-100, saving.getSaving());

        saving = offer.computeSaving(5, unitPrice);
        assertEquals(-100, saving.getSaving());
    }

     @Test
    public void testComputeSavingUsingItemsList() {

        OfferNForM offer = new OfferNForM(10, "Beans 3 For 2", 3, 2);

        List<PricedItem> items = new ArrayList<>();
        items.add(new PricedItem(10, "Beans", 50));
        OfferSaving saving = offer.computeSaving(items);
        assertEquals(0, saving.getSaving());

        items.add(new PricedItem(10, "Beans", 50));
        saving = offer.computeSaving(items);
        assertEquals(0, saving.getSaving());

        items.add(new PricedItem(10, "Beans", 50));
        saving = offer.computeSaving(items);
        assertEquals(-50, saving.getSaving());

        items.add(new PricedItem(10, "Beans", 50));
        saving = offer.computeSaving(items);
        assertEquals(-50, saving.getSaving());

    }
}
