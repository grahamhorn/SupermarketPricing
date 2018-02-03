/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.HashMap;
import java.util.Map;

/**
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

    public Offer getOffer(int id) {
        return offers.get(id);
    }

    public void clear() {
        offers.clear();
    }
}
