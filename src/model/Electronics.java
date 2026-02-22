package model;

public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(String name, double price, int warrantyMonths) {
        this.name = name;
        this.basePrice = price;
        this.category = "ELECTRONICS";
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateShipping() { 
        return basePrice * 0.05; 
    }

    @Override
    public String getDescription() {
        return name + " [Electrónica] - Garantía: " + warrantyMonths + " meses";
    }
}