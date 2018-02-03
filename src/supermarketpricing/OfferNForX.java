/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/** Buy N items for X pence.
 *
 * @author gsh
 */
public class OfferNForX extends Offer{
    private int n;
    private int x;

    public OfferNForX(String description, int n, int x) {
        this.description = description;
        this.n = n;
        this.x = x;
    }

    @Override
    public OfferSaving computeSaving(int numItems, int unitPrice) {
        int offerMultiple = numItems / n;
        int saving = - offerMultiple * (n * unitPrice - x);
        return new OfferSaving(description, saving);
    }
}
