/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** This offer is for N items from a set of item ids for a price of X pence.
 * It assumes that the offer is applied by grouping the cheapest N items, and then
 * the next cheapest N items, etc until the PricedItem list is empty.
 * It also assumes that x is less than n times the price of the cheapest item in the offer.
 * @author gsh
 */
public class OfferNFromSetForX extends Offer {
    private Set<Integer> ids;
    private int n;
    private int x;

    public OfferNFromSetForX(Set<Integer> ids, String description, int n, int x) {
        super(description);
        this.ids = ids;
        this.n = n;
        this.x = x;
    }

    @Override
    public OfferSaving computeSaving(List<PricedItem> items) {
        items = new ArrayList<PricedItem>(items);
        // Order list by descending price     
        items.sort((a, b) -> a.getPrice() > b.getPrice() ? -1 : a.getPrice() == b.getPrice() ? 0 : 1);
        
        int saving = 0;
        // continue until list contains fewer than n items
        while (items.size() >= n) {
            // remove the last n items; compute saving
            List<PricedItem> savingsItems = items.subList(items.size() - n, items.size());
            int priceSum = 0;
            for (PricedItem item : savingsItems) {
                priceSum += item.getPrice();
            }
            saving -= (priceSum - x);
            savingsItems.clear();
        }
        
        return new OfferSaving(description, saving);
    }

    @Override
    public boolean isApplicable(int id) {
        return ids.contains(id);
    }

}
