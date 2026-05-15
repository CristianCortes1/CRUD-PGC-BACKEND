# API Endpoints — CRUD-PGC

Base URL: http://192.168.1.15:8080

Notas:
- Sustituya el puerto si su aplicación corre en otro puerto.
- Los endpoints listados están basados en los controladores del proyecto.

## Autenticación
- POST /api/auth/login
  - Descripción: autentica usuario y devuelve token/DTO
  - Body (JSON): {"username":"...","password":"..."}
  - Ejemplo curl:
    ```bash
    curl -X POST http://192.168.1.15:8080/api/auth/login \
      -H "Content-Type: application/json" \
      -d '{"username":"user","password":"pass"}'
    ```

## Usuarios
- POST /api/users
  - Descripción: crear nuevo usuario
  - Body: `UsuarioRequestDTO` (JSON)
  - Ejemplo:
    ```bash
    curl -X POST http://192.168.1.15:8080/api/users \
      -H "Content-Type: application/json" \
      -d '{...}'
    ```

## Entregas (Deliveries)
- PUT /api/deliveries/{id}/confirm
  - Descripción: confirmar entrega con id
  - Ejemplo:
    ```bash
    curl -X PUT http://192.168.1.15:8080/api/deliveries/123/confirm
    ```

## Inventario
- GET /api/inventory/station/{id}
  - Descripción: listar inventario por estación
  - Ejemplo:
    ```bash
    curl http://192.168.1.15:8080/api/inventory/station/10
    ```

## Precios
- GET /api/prices/nearby?lat={lat}&long={long}
  - Descripción: listar precios cercanos (por coordenadas)
  - Ejemplo:
    ```bash
    curl "http://192.168.1.15:8080/api/prices/nearby?lat=4.7&long=-74.0"
    ```

## Transacciones
- POST /api/transactions
  - Descripción: crear transacción/venta
  - Body: `TransactionRequestDTO` (JSON)
  - Ejemplo:
    ```bash
    curl -X POST http://192.168.1.15:8080/api/transactions \
      -H "Content-Type: application/json" \
      -d '{...}'
    ```

## Servidor / Salud
- GET /server
  - Descripción: información simple del servidor (puerto)
  - Ejemplo:
    ```bash
    curl http://192.168.1.15:8080/server
    ```

---

Si quiere, puedo:
- Añadir los formatos exactos de los DTOs (`UsuarioRequestDTO`, `TransactionRequestDTO`, etc.) en este mismo `ENDPOINTS.md`.
- Incluir ejemplos de respuestas exitosas y errores comunes.
