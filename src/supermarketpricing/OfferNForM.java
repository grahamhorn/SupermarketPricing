/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/** Buy N items for the price of M.
 * Assumes the simplest form i.e. 2 for 1 rather than 4 for 2.
 * @author gsh
 */
public class OfferNForM {
    private String description;
    private int n;
    private int m;

    public OfferNForM(String description, int n, int m) {
        this.description = description;
        this.n = n;
        this.m = m;
    }

    public OfferSaving computeSaving(int numItems, int unitPrice) {
        int numFree = numItems / n;
        int saving = - numFree * unitPrice;
        return new OfferSaving(description, saving);
    }
}
