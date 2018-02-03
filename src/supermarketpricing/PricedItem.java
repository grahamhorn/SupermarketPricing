/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/**
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


}
