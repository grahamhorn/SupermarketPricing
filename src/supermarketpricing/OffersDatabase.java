/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.HashMap;
import java.util.Map;

/** A singleton containing all of the offers that can be used to make savings.
 *
 * @author gsh
 */
public class OffersDatabase {
    private static final OffersDatabase instance = new OffersDatabase();

    private Map<Integer, Offer> offers;
    private OffersDatabase() {
        offers = new HashMap<>();
    }

    public static OffersDatabase getInstance() {
        return instance;
    }
    
    public void addOffer(int id, Offer offer) {
        offers.put(id, offer);
    }

    /**
     *
     * @param id The id of the Item
     * @return The Offer for that Item or null if there is none.
     */
    public Offer getOffer(int id) {
        return offers.get(id);
    }

    public void clear() {
        offers.clear();
    }
}
