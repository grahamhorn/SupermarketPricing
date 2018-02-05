/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Basket holds a list of items to be purchased.
 *
 * @author gsh
 */
public class Basket {

    private List<Item> items;

    public Basket() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    /** Calculate the price the customer must pay for the items in the basket.
     *
     * @return a Receipt
     */
    public Receipt calculate() {
        Receipt receipt = new Receipt();

        Set<Offer> offers = new HashSet<>();
        for (Item item : items) {
            receipt.addItem(item.computePrice());
            // look up if there is an applicable offer; add to a set of Offer
            Offer offer = OffersDatabase.getInstance().getOffer(item.getId());
            if (offer != null) {
                offers.add(offer);
            }
        }

//        System.out.println("Applicable Offers: " + offers.toString());

        // apply the offers
        // for each offer, find the applicable items
        // and create a (shrinking) list of the remaining items
        List<PricedItem> remainingItems = new ArrayList<>(receipt.getItems());

        for (Offer offer : offers) {
            List<PricedItem> applicableItems = new ArrayList<>();
            List<PricedItem> newRemainingItems = new ArrayList<>();
            
            for (PricedItem item : remainingItems) {
                if (offer.isApplicable(item.getId())) {
                    applicableItems.add(item);
                } else {
                    newRemainingItems.add(item);
                }
            }
            receipt.addOfferSaving(offer.computeSaving(applicableItems));
            remainingItems = newRemainingItems;         
        }

        receipt.computeTotal();

        return receipt;
    }
}
