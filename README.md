# Proxy de Caché - Comparativa Antes vs. Después

Este proyecto demuestra la implementación y los beneficios del patrón de diseño **Proxy** mediante una comparativa directa entre un sistema sin optimizar y uno optimizado.

## 📁 Estructura del Proyecto

El código está dividido en dos paquetes para facilitar la comparación:

### 1. 🔴 Paquete `org.example.antes` (Sin el Patrón)
Representa el sistema original con problemas de rendimiento.
- **`RealGoldPriceService`**: Clase concreta que simula una consulta lenta de 3 segundos.
- **`MainAntes`**: Clase de ejecución. Realiza 3 consultas seguidas.
- **Resultado esperado**: Tiempo total de ejecución ≈ **9 segundos** (3s + 3s + 3s).
- **Problema**: El servidor se satura procesando peticiones idénticas una y otra vez.

### 2. 🟢 Paquete `org.example.despues` (Con el Patrón Proxy)
Representa el sistema optimizado y desacoplado.
- **`GoldPriceService`**: Interfaz que define el contrato. Permite que el cliente sea agnóstico a la implementación.
- **`RealGoldPriceService`**: Implementación real de la fuente lenta.
- **`GoldPriceProxy`**: El intermediario. Implementa la lógica de caché:
    - Si es la primera vez, consulta al servicio real (3s).
    - Si el dato ya existe, lo devuelve instantáneamente (0ms).
- **`MainDespues`**: Clase de ejecución. Realiza 3 consultas seguidas.
- **Resultado esperado**: Tiempo total de ejecución ≈ **3 segundos** (3s + 0s + 0s).

---

## 🚀 Cómo Probar la Diferencia

1. **Ejecuta `MainAntes`**:
   - Observa cómo la consola imprime "[Servicio Real]" tres veces.
   - Nota la pausa de 3 segundos entre cada impresión.
   - El tiempo final será de aproximadamente 9000ms.

2. **Ejecuta `MainDespues`**:
   - Observa cómo la consola imprime "[Proxy] Caché vacía" solo una vez.
   - Las siguientes consultas imprimirán "[Proxy] Devolviendo valor de la caché" al instante.
   - El tiempo final será de aproximadamente 3000ms.

## 🏛 Conclusión Arquitectónica
El uso del Proxy no solo mejora el **rendimiento** (de 9s a 3s), sino que también mejora el **diseño**:
- **Desacoplamiento**: El cliente ahora depende de una interfaz, no de una clase concreta.
- **Responsabilidad Única**: El servicio real solo se encarga de buscar datos; el Proxy se encarga de la optimización y el control de acceso.
