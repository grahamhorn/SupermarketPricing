/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/** A PricedItem contains the id, the description to be shown on the receipt, and the price.
 *
 * @author gsh
 */
public class PricedItem {
    private int id;
    private String description;
    private int price;

    public PricedItem(int id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return id + " costs " + price + "p";
    }
}
