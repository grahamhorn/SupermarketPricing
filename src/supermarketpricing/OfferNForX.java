/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.List;

/**
 * Buy N items for X pence.
 *
 * @author gsh
 */
public class OfferNForX extends Offer {

    private int id;
    private int n;
    private int x;

    public OfferNForX(int id, String description, int n, int x) {
        this.id = id;
        this.description = description;
        this.n = n;
        this.x = x;
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
        int offerMultiple = numItems / n;
        int saving = -offerMultiple * (n * unitPrice - x);
        return new OfferSaving(description, saving);
    }

    @Override
    public boolean isApplicable(int id) {
        return this.id == id;
    }
}
