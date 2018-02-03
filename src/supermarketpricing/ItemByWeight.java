/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.text.DecimalFormat;

/**
 *
 * @author gsh
 */
public class ItemByWeight extends Item{

    private DecimalFormat df = new DecimalFormat("0.00");
    private float weight;

    public ItemByWeight(int id, String name, float weight) {
        super(id, name);
        this.weight = weight;
    }

    @Override
    public PricedItem computePrice() {
        int pricePerKg = PricesDatabase.getInstance().lookUpPrice(id);
        return new PricedItem(id, name + "\n" + weight+ "kg @ £" + df.format(pricePerKg/100.0) + "/kg", (int)Math.ceil(pricePerKg * weight));
    }

}
