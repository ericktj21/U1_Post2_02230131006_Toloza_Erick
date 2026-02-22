package strategy;

public class MemberPricing implements PricingStrategy {
    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.90; // 10% de descuento
    }

    @Override
    public String getDescription() { 
        return "Precio de Miembro (10% de descuento)"; 
    }
}