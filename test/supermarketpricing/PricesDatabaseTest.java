/*
 * Supermarket Pricing exercise
 */
package supermarketpricing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gsh
 */
public class PricesDatabaseTest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        PricesDatabase.getInstance().clear();
    }

    @Test
    public void testLookupPrice() {
        try {
            int price = PricesDatabase.getInstance().lookUpPrice(0);
            fail("PriceNotFoundException expected");
        }
        catch (PriceNotFoundException e) {
           
        }

        PricesDatabase.getInstance().storePrice(0, 20);

        try {
            int price = PricesDatabase.getInstance().lookUpPrice(0);
            assertEquals(20, price);
        }
        catch (PriceNotFoundException e) {
           fail("PriceNotFoundException not expected");
        }
    }
}
