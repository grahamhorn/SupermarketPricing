/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        HashSet<Integer> ids = new HashSet<>();
        ids.add(400);
        ids.add(401);
        ids.add(402);
        ids.add(403);
        Offer offer = new OfferNFromSetForX(ids, "3 Ales for £5", 3, 500);

        List<PricedItem> items = new ArrayList<>();
        items.add(new PricedItem(401, "IPA", 185));
        items.add(new PricedItem(402, "Stout", 199));
        items.add(new PricedItem(403, "Porter", 175));
        items.add(new PricedItem(400, "Best Bitter", 170));

        assertTrue(offer.isApplicable(401));
        assertFalse(offer.isApplicable(10));

        OfferSaving saving = offer.computeSaving(items);

        assertEquals(-(170 + 175 + 185 - 500), saving.getSaving());
    }
}
