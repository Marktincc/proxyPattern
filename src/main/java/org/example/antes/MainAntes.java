package org.example.antes;

public class MainAntes {
    public static void main(String[] args) {
        RealGoldPriceService service = new RealGoldPriceService();

        System.out.println("--- EJECUCIÓN SIN PROXY (LENTO) ---");
        
        long start = System.currentTimeMillis();
        
        // Cada consulta tarda 3 segundos. Total: 9 segundos.
        System.out.println("Consulta 1: $" + service.getPrice());
        System.out.println("Consulta 2: $" + service.getPrice());
        System.out.println("Consulta 3: $" + service.getPrice());
        
        long end = System.currentTimeMillis();
        System.out.println("TIEMPO TOTAL: " + (end - start) + " ms");
    }
}
