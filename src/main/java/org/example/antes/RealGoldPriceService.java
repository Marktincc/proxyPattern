package org.example.antes;

/**
 * ESTADO: ANTES DEL PATRÓN
 * Aquí no hay interfaz ni proxy. El cliente accede directamente a la fuente lenta.
 */
public class RealGoldPriceService {
    public double getPrice() {
        try {
            System.out.println("[Servicio Real] Consultando base de datos pesada...");
            Thread.sleep(3000); // 3 segundos de espera obligatoria
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return 2350.75;
    }
}
