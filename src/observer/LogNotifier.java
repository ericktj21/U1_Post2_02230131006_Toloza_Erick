package observer;
import java.time.LocalDateTime;

public class LogNotifier implements OrderObserver {
    @Override
    public void update(String orderId, String oldStatus, String newStatus) {
        // Imprime el mensaje con la fecha y hora actual (timestamp)
        System.out.println("[LOG - " + LocalDateTime.now() + "] SISTEMA: Orden " + orderId + " actualizada. (" + oldStatus + " -> " + newStatus + ")");
    }
}