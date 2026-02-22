package strategy;

public class RegularPricing implements PricingStrategy {
    @Override
    public double calculateFinalPrice(double price) {
        return price; // Sin descuento
    }

    @Override
    public String getDescription() { 
        return "Precio regular (Sin descuento)"; 
    }
}