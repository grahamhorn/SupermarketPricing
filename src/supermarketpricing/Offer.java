/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.List;

/**
 *
 * @author gsh
 */
public abstract class Offer {
    protected String description;

    public abstract OfferSaving computeSaving(List<PricedItem> items);

    public abstract boolean isApplicable(int id);

    public String toString() {
        return description;
    }
}
