/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The Receipt is what the customer will see at the end.
 *
 * @author gsh
 */
public class Receipt {

    private final DecimalFormat df = new DecimalFormat("0.00");

    private List<PricedItem> items;
    private int subtotal;
    private List<OfferSaving> savings;
    private int totalSavings;
    private int total;

    public Receipt() {
        items = new ArrayList<>();
        subtotal = 0;
        savings = new ArrayList<>();
        totalSavings = 0;
        total = 0;
    }

    public void addItem(PricedItem item) {
        items.add(item);
        subtotal += item.getPrice();
    }

    public void addOfferSaving(OfferSaving saving) {
        savings.add(saving);
        totalSavings += saving.getSaving();
    }

    public void computeTotal() {
        total = subtotal + totalSavings;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getTotalSavings() {
        return totalSavings;
    }

    public int getTotal() {
        return total;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (PricedItem item : items) {
            builder.append(item.getDescription()).append("\t").append(df.format(item.getPrice() / 100.0)).append("\n");
        }

        if (savings.size() > 0) {
            builder.append("\nSubtotal").append("\t\t").append(df.format(subtotal / 100.0));
            builder.append("\nSavings");

            for (OfferSaving saving : savings) {
                builder.append(saving.getDescription()).append("\t\t").append(df.format(saving.getSaving() / 100.0)).append("\n");
            }
            builder.append("\nTotal Savings").append("\t\t").append(df.format(totalSavings / 100.0));
        }
        builder.append("\n\nTotal to pay").append("\t\t").append(df.format(total / 100.0));

        return builder.toString();
    }
}
