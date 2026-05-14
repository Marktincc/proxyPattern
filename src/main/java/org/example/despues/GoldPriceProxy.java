package org.example.despues;

public class GoldPriceProxy implements GoldPriceService {
    private final RealGoldPriceService realService;
    private Double cache;

    public GoldPriceProxy() {
        this.realService = new RealGoldPriceService();
    }

    @Override
    public double getPrice() {
        if (cache == null) {
            System.out.println("[Proxy] Caché vacía. Llamando al servicio real...");
            cache = realService.getPrice();
        } else {
            System.out.println("[Proxy] Devolviendo valor de la caché instantáneamente.");
        }
        return cache;
    }
}
