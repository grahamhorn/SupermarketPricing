/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.HashMap;
import java.util.Map;

/** The PricesDatabase is a singleton which stores the price for each product ID.
 *  The price is stored in pence. If the product is sold by weight it is in pence per kg,
 * otherwise it is the unit price.
 *
 * @author gsh
 */
public class PricesDatabase {

    private final static PricesDatabase instance = new PricesDatabase();
    private final Map<Integer, Integer> priceMap;

    private PricesDatabase() {
        priceMap = new HashMap<Integer, Integer>();
    }

    public static PricesDatabase getInstance() {
        return instance;
    }

    public int lookUpPrice(int id) throws PriceNotFoundException {
        if (priceMap.containsKey(id)) {
            return priceMap.get(id);
        } else {
            throw new PriceNotFoundException(id);
        }
    }

    public void storePrice(int id, int price) {
        // TODO consider what should happen wrt reporting the old price
        priceMap.put(id, price);
    }

    public void removePrice(int id) {
        priceMap.remove(id);
    }

    /**
     * Remove all pricing data
     */
    public void clear() {
        priceMap.clear();
    }
}
