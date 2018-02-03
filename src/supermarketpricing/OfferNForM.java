/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.List;

/** Buy N items for the price of M.
 * Assumes the simplest form i.e. 2 for 1 rather than 4 for 2.
 * @author gsh
 */
public class OfferNForM extends Offer{
    private int id;
    private int n;
    private int m;

    public OfferNForM(int id, String description, int n, int m) {
        this.id = id;
        this.description = description;
        this.n = n;
        this.m = m;
    }

    @Override
    public boolean isApplicable(int id) {
        return this.id == id;
    }

    @Override
    public OfferSaving computeSaving(List<PricedItem> items) {
        if (items.size() > 0) {
            return computeSaving(items.size(), items.get(0).getPrice());
        } else {
            return new OfferSaving(description, 0);
        }
    }

    public OfferSaving computeSaving(int numItems, int unitPrice) {
        int numFree = numItems / n;
        int saving = - numFree * unitPrice;
        return new OfferSaving(description, saving);
    }
}
