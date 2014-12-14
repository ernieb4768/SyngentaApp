package com.syngenta.rhoffman.syngenta;

/**
 * An object to create a product.
 *
 * The product has three properties: name, weight, and capacity.
 * Name is a String that tells what the product is called.
 * Weight is a double that tells how much the product weighs in pounds per gallon.
 * Capacity is an int that tells how many gallons will fit in a trailer.
 *
 * This object will also have three methods, one per property to simply display that property.
 */
public class Product {

    public String name;
    public double weight;
    public int capacity;

    public Product(String name, double weight, int capacity) {

        name = this.name;
        weight = this.weight;
        capacity = this.capacity;

    }

}
