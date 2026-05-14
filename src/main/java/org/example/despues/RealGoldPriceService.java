package org.example.despues;

public class RealGoldPriceService implements GoldPriceService {
    @Override
    public double getPrice() {
        try {
            System.out.println("[Servicio Real] Consultando fuente lenta...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return 2350.75 + (Math.random() * 5);
    }
}
