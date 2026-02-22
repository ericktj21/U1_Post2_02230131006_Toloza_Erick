package strategy;

public class BulkPricing implements PricingStrategy {
    private int quantity; // Guardamos la cantidad

    // El constructor recibe la cantidad de productos
    public BulkPricing(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateFinalPrice(double price) {
        // Lógica del descuento por volumen
        if (quantity >= 10) {
            return price * 0.75; // 25% de descuento si compra 10 o más
        } else if (quantity >= 5) {
            return price * 0.90; // 10% de descuento si compra 5 o más
        }
        
        return price; // Precio normal si compra menos de 5
    }

    @Override
    public String getDescription() { 
        return "Descuento por cantidad (" + quantity + " unidades)"; 
    }
}