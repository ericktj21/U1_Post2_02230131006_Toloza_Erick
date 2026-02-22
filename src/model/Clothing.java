package model;

public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        this.name = name;
        this.basePrice = price;
        this.category = "CLOTHING";
        this.size = size;
    }

    @Override
    public double calculateShipping() { 
        return 5.0; // Precio fijo de envío para ropa
    }

    @Override
    public String getDescription() {
        return name + " [Ropa] - Talla: " + size;
    }
}