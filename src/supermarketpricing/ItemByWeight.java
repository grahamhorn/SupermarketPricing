/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/**
 *
 * @author gsh
 */
public class ItemByWeight extends Item{

    private float weight;

    public ItemByWeight(int id, String name, float weight) {
        super(id, name);
        this.weight = weight;
    }

    @Override
    public int computePrice() {
        return (int)(PricesDatabase.getInstance().lookUpPrice(id) * weight);
    }

}
