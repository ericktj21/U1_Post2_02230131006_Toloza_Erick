import observer.*;
import strategy.*;
import service.OrderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE E-COMMERCE ===\n");

        // 1. Configuramos los Notificadores (Patrón Observer)
        EmailNotifier emailNotifier = new EmailNotifier();
        SMSNotifier smsNotifier = new SMSNotifier();
        LogNotifier logNotifier = new LogNotifier();

        // --- PRIMER PEDIDO: Cliente normal sin descuentos ---
        System.out.println(">>> Creando Pedido 001 (Cliente Regular)");
        OrderService order1 = new OrderService("ORD-001", new RegularPricing());
        
        // Suscribimos a los observadores
        order1.subscribe(emailNotifier);
        order1.subscribe(logNotifier);

        // Agregamos productos (Patrón Factory)
        order1.addProduct("ELECTRONICS", "Laptop Dell", 1200.0);
        order1.addProduct("CLOTHING", "Camiseta Azul", 25.0);
        
        // Imprimimos el resumen (Patrón Strategy)
        order1.printOrderSummary();

        // Cambiamos el estado para probar notificaciones (Patrón Observer)
        order1.setStatus("PROCESSING");
        System.out.println();


        // --- SEGUNDO PEDIDO: Cliente VIP en Black Friday ---
        System.out.println(">>> Creando Pedido 002 (Promoción Black Friday)");
        OrderService order2 = new OrderService("ORD-002", new BlackFridayPricing());
        
        // Este cliente quiere recibir avisos también por SMS
        order2.subscribe(emailNotifier);
        order2.subscribe(smsNotifier);
        order2.subscribe(logNotifier);

        // Agregamos productos
        order2.addProduct("FOOD", "Caja de Chocolates", 15.0);
        order2.addProduct("ELECTRONICS", "Audífonos Sony", 150.0);

        order2.printOrderSummary();

        order2.setStatus("SHIPPED");
        order2.setStatus("DELIVERED");
    }
}