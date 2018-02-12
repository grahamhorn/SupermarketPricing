/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author gsh
 */
public class OfferNFromSetForXTest {

    @Test
    public void test3AlesFor5pounds() {
        Set<Integer> ids = new HashSet<>(Arrays.asList(400, 401, 402, 403));

        Offer offer = new OfferNFromSetForX(ids, "3 Ales for £5", 3, 500);

        List<PricedItem> items = Arrays.asList(new PricedItem(401, "IPA", 185),
                new PricedItem(402, "Stout", 199),
                new PricedItem(403, "Porter", 175),
                new PricedItem(400, "Best Bitter", 170));

        assertTrue(offer.isApplicable(401));
        assertFalse(offer.isApplicable(10));

        OfferSaving saving = offer.computeSaving(items);

        assertEquals(-(170 + 175 + 185 - 500), saving.getSaving());
        assertEquals(4, items.size());
    }
}
