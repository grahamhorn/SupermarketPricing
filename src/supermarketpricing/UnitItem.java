/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/** A UnitItem represents an Item that is sold by the unit, e.g. a tin of beans.
 *
 * @author gsh
 */
public class UnitItem extends Item {

    public UnitItem(int id, String name) {
        super(id, name);
    }

    @Override
    public int computePrice() {
        return PricesDatabase.getInstance().lookUpPrice(id);
    }


}
