# Proxy de Caché - Optimización de Consultas BD

Este proyecto es un ejemplo práctico del patrón de diseño **Proxy** aplicado a un sistema financiero que consulta el precio del oro.

## 🚨 El Problema
Un sistema realiza consultas a una fuente lenta (API externa o BD pesada) que tarda **3 segundos** por respuesta. Si 50 usuarios consultan al mismo tiempo, el servidor se bloquea procesando peticiones redundantes.

## 🛠 La Solución: Proxy Pattern
Se implementó un intermediario que controla el acceso al servicio real y gestiona una caché local.

### 👨‍💻 Enfoque del Desarrollador
Se centró en la implementación técnica:
- Crear un atributo para guardar el último resultado (`cachedPrice`).
- Retornar el valor guardado si existe, evitando la llamada al servicio real.
- **Resultado:** Reducción del tiempo de respuesta de 3000ms a 0ms.

### 🏛 Enfoque del Arquitecto
Se centró en los compromisos (Trade-offs):
- **Coherencia vs. Latencia:** Introdujo el **TTL (Time To Live)** de 10 segundos.
- Decidió qué tan viejo puede ser un dato antes de considerarse inválido.
- **Resultado:** El sistema es escalable pero mantiene los datos actualizados periódicamente.

## 📂 Estructura del Código
- `GoldPriceService`: Interfaz común.
- `RealGoldPriceService`: La fuente "lenta" original.
- `GoldPriceProxy`: El intermediario con lógica de caché y expiración.
- `Main`: Simulador de tráfico de usuarios.

## 🚀 Cómo ejecutar
1. Compila el proyecto con Maven o tu IDE preferido.
2. Ejecuta la clase `Main`.
3. Observa en la consola cómo los tiempos de respuesta cambian drásticamente cuando el Proxy decide usar la caché.
