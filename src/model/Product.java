package model;

public abstract class Product {
    protected String name;
    protected double basePrice;
    protected String category;

    public abstract double calculateShipping();
    public abstract String getDescription();

    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }
}