/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.List;

/** Buy N items for the price of M.
 * 
 * @author gsh
 */
public class OfferNForM extends Offer{
    private int id;
    private int n;
    private int m;

    public OfferNForM(int id, String description, int n, int m) {
        super(description);
        this.id = id;
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
        int offerMultiple = numItems / n;
        int saving = - offerMultiple * (n - m) * unitPrice;
        return new OfferSaving(description, saving);
    }
}
