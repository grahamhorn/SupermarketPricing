# Supermarket Pricing exercise

Graham Horn

This repository contains a Java implementation for the supermarket pricing exercise.

## Representation

Basket holds a list of Items to be purchased. It has a calculate method that
generates a Receipt which shows the individual items (and the price for each one)
and any savings made due to applicable Offers.

Item is an abstract class with two concrete subclasses: UnitItem for items
priced per unit (e.g. baked beans, coke) and ItemByWeight for items that have a
price per kg. Each item has an id which should be unique (like a barcode).

The base price (in pence) for items is stored in a central (singleton) PricesDatabase. For items sold
by weight this contains the price in pence per kg.

When the Basket is processed a PricedItem is created for each Item in the Basket.
This allows for prices to change between adding an Item to the Basket and calculating the
final price. (For instance, a shop could have dynamic pricing based on stock levels or time/expiry date).

Offer is an abstract class. It has a method to determine if it is applicable to
a given item. An offer allows for a discount to be applied to a list of items, such as
multiples of the same item or items within a set (e.g. ales). Subclasses implement different types of offer.

Offers are stored in a central (singleton) OffersDatabase. When an Item is processed
this is checked to see if there is an applicable offer. After all items have been processed
then the set of offers is applied to calculate the discounts.

## Assumptions

1. No checking is made that the Item ids are unique.
2. Only one offer will apply to a given item at any time.
3. Whilst a PriceNotFoundException has been created it is not caught in the computePrice methods
of the Item subclasses - it is assumed that there is a price in the PricesDatabase for all ids.

## Usage

The following steps are required:
1. Populate the PricesDatabase with base prices for item ids
2. Populate the OffersDatabase with any offers. If an offer applies to multiple item ids
then it must be entered against each id (e.g. ales)
3. Create a Basket and add items to it.
4. Call the calculate method on the Basket to get a Receipt which can be displayed or interrogated programmatically.

See BasketTest for examples.

## Possible extensions

An expiry date could be added to items and offers generated that discount the
price if the date is close. Use by and best before dates would be treated differently.

Other offer types such as "2 for £7.50 or 3 for £10" could be added. This should
be treated as a single offer.

The PriceNotFoundException should be caught and handled appropriately.

Add Coupons - money off on specific items.
