package service;

import model.Product;
import factory.ProductFactory;
import observer.OrderObserver;
import observer.OrderSubject;
import strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements OrderSubject {
    private String orderId;
    private String status;
    private List<Product> products;
    private List<OrderObserver> observers;
    private PricingStrategy pricingStrategy;

    public OrderService(String orderId, PricingStrategy pricingStrategy) {
        this.orderId = orderId;
        this.status = "CREATED";
        this.products = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.pricingStrategy = pricingStrategy;
    }

    // --- Uso del Patrón Factory ---
    public void addProduct(String type, String name, double price) {
        // Usamos la fábrica para crear el producto sin importar de qué tipo sea
        Product product = ProductFactory.createProduct(type, name, price);
        products.add(product);
        System.out.println("Producto agregado: " + product.getDescription() + " - $" + price);
    }

    // --- Uso del Patrón Strategy ---
    public void printOrderSummary() {
        System.out.println("\n--- Resumen del Pedido: " + orderId + " ---");
        System.out.println("Estrategia aplicada: " + pricingStrategy.getDescription());
        
        double subtotal = 0;
        double totalShipping = 0;

        for (Product p : products) {
            subtotal += p.getBasePrice();
            totalShipping += p.calculateShipping();
        }

        // Calculamos el descuento usando la estrategia elegida
        double totalWithDiscount = pricingStrategy.calculateFinalPrice(subtotal);
        double finalTotal = totalWithDiscount + totalShipping;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total con descuento: $" + totalWithDiscount);
        System.out.println("Costo de envío: $" + totalShipping);
        System.out.println("TOTAL FINAL A PAGAR: $" + finalTotal);
        System.out.println("----------------------------------\n");
    }

    // --- Uso del Patrón Observer ---
    public void setStatus(String newStatus) {
        String oldStatus = this.status;
        this.status = newStatus;
        // Cuando cambia el estado, notificamos a todos los suscriptores
        notifyObservers(orderId, oldStatus, newStatus);
    }

    @Override
    public void subscribe(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String orderId, String oldStatus, String newStatus) {
        for (OrderObserver observer : observers) {
            observer.update(orderId, oldStatus, newStatus);
        }
    }
}