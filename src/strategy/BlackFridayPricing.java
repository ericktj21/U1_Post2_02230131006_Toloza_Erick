package strategy;

public class BlackFridayPricing implements PricingStrategy {
    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.70; // 30% de descuento
    }

    @Override
    public String getDescription() { 
        return "Promoción Black Friday (30% de descuento)"; 
    }
}