package observer;

public class EmailNotifier implements OrderObserver {
    @Override
    public void update(String orderId, String oldStatus, String newStatus) {
        System.out.println("[EMAIL] Hola! Te informamos que tu pedido " + orderId + " ha cambiado de " + oldStatus + " a " + newStatus + ".");
    }
}