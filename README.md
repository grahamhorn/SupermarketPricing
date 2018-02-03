# Supermarket Pricing exercise

This repository contains an implementation to address the supermarket pricing exercise.

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
multiples of the same item or items within a set (e.g. ales).

Offers are stored in a central (singleton) OffersDatabase. When an Item is processed
this is checked to see if there is an applicable offer.

## Assumptions

No checking is made that the Item ids are unique.
Only one offer will apply to a given item at any time.

## Possible extensions

An expiry date could be added to items and offers generated that discount the
price if the date is close.

Other offer types such as "2 for £7.50 or 3 for £10" could be added. This should
be treated as a single offer.
