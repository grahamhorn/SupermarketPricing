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
public class OfferNForXTest {

   @Test
    public void testComputeSaving() {
        int unitPrice = 70;

        OfferNForX offer = new OfferNForX(20, "2 cokes for £1", 2, 100);
        
        OfferSaving saving = offer.computeSaving(1, unitPrice);
        assertEquals(0, saving.getSaving());

        saving = offer.computeSaving(2, unitPrice);
        assertEquals(-40, saving.getSaving());

        saving = offer.computeSaving(3, unitPrice);
        assertEquals(-40, saving.getSaving());

        saving = offer.computeSaving(4, unitPrice);
        assertEquals(-80, saving.getSaving());
    }
}
