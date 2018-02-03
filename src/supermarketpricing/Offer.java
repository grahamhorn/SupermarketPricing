/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/**
 *
 * @author gsh
 */
public abstract class Offer {
    protected String description;

    public abstract OfferSaving computeSaving(int numItems, int unitPrice);
}
