package org.example.despues;

public class MainDespues {
    public static void main(String[] args) {
        // El cliente usa la interfaz, ahora el Proxy controla el flujo.
        GoldPriceService service = new GoldPriceProxy();

        System.out.println("--- EJECUCIÓN CON PROXY (OPTIMIZADO) ---");
        
        long start = System.currentTimeMillis();
        
        // Solo la primera tarda 3s. Las demás son instantáneas.
        System.out.println("Consulta 1: $" + service.getPrice());
        System.out.println("Consulta 2: $" + service.getPrice());
        System.out.println("Consulta 3: $" + service.getPrice());
        
        long end = System.currentTimeMillis();
        System.out.println("TIEMPO TOTAL: " + (end - start) + " ms");
    }
}
