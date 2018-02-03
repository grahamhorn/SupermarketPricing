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
}
