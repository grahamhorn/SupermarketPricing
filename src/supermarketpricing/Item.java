/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/** An Item represents something found in a shopping basket.
 * Its price depends on the type of item and so is computed by the subclasses.
 * @author gsh
 */
public abstract class Item {
    protected int id;
    protected String name;

    protected Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract PricedItem computePrice();
}
