/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

/**
 *
 * @author gsh
 */
public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException(int id) {
        super("No price found for ID: " + id);
    }
}
