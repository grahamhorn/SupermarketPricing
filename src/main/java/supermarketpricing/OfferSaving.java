/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/** The savings made by applying an offer to a basket of items.
 *
 * @author gsh
 */
public class OfferSaving {
    private String description;
    private int saving;

    public OfferSaving(String description, int saving) {
        this.description = description;
        this.saving = saving;
    }

    public String getDescription() {
        return description;
    }

    /**
     *
     * @return the saving in pence (a negative value)
     */
    public int getSaving() {
        return saving;
    }


}
