/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.util.ArrayList;
import java.util.List;

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

    public Receipt calculate() {
        Receipt receipt = new Receipt();

        for (Item item : items) {
            receipt.addItem(item.computePrice());
            // TODO look up if there is an applicable offer; add to a set of Offer
        }

        // TODO apply the offers

        receipt.computeTotal();

        return receipt;
    }
}
