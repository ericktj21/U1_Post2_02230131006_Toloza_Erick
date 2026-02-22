package model;

public class Food extends Product {
    private int expirationDays;

    public Food(String name, double price, int expirationDays) {
        this.name = name;
        this.basePrice = price;
        this.category = "FOOD";
        this.expirationDays = expirationDays;
    }

    @Override
    public double calculateShipping() { 
        return basePrice * 0.10; // Envío especial por refrigeración
    }

    @Override
    public String getDescription() {
        return name + " [Comida] - Expira en: " + expirationDays + " días";
    }
}