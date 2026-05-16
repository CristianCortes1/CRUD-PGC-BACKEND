# CRUD-PGC

<!-- badges row -->
[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-yellowgreen)](#licencia)

## Descripción Corta

Sistema de gestión backend para administración de la cadena de suministro de combustible, proporcionando una API RESTful robusta para gestionar estaciones de servicio, distribuidores, ventas, subsidios y operaciones de combustible. Desarrollado con Java y Spring Boot.

## Tabla de Contenidos

- [Características](#características)
- [Tech Stack](#tech-stack)
- [Prerrequisitos](#prerrequisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Variables de Entorno](#variables-de-entorno)
- [Estructura del Proyecto](#estructura-del-proyecto)

## Características

- Operaciones CRUD completas para múltiples entidades del dominio
- Gestión de estaciones de servicio y distribuidores de combustible
- Control de inventario y movimientos de combustible
- Registro y seguimiento de ventas a clientes
- Administración de subsidios y reglas de negocio
- Sistema de autenticación y gestión de usuarios
- Integración con API de enrutamiento (OpenRouteService)
- Manejo centralizado de excepciones
- API RESTful estructurada con DTOs y mapeadores

## Tech Stack

| Tecnología | Versión |
|------------|---------|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | (incluido en Spring Boot) |
| Spring Web MVC | (incluido en Spring Boot) |
| PostgreSQL | - |
| Lombok | Latest |
| Maven | 3.x (wrapper incluido) |

## Prerrequisitos

- JDK 17 instalado
- PostgreSQL instalado y configurado
- Maven (opcional, se incluye Maven Wrapper)

## Instalación

```bash
# Clonar el repositorio
git clone <url-del-repositorio>
cd CRUD-PGC

# Construir el proyecto
./mvnw clean install

# Ejecutar la aplicación
./mvnw spring-boot:run
```

## Uso

### Ejemplo: Obtener todas las estaciones de servicio

```bash
GET http://localhost:8080/estaciones
```

**Respuesta:**

```json
[
  {
    "id": 1,
    "nombre": "Estación Norte",
    "direccion": "Carrera 45 #12-30",
    "capacidad": 50000
  }
]
```

### Ejemplo: Registrar una nueva venta

```bash
POST http://localhost:8080/ventas
Content-Type: application/json

{
  "estacionId": 1,
  "cantidad": 100.5,
  "tipoCombustible": "GASOLINA"
}
```

## Variables de Entorno

| Variable | Descripción | Valor por Defecto |
|----------|-------------|-------------------|
| `SPRING_DATASOURCE_URL` | URL de conexión a PostgreSQL | `jdbc:postgresql://localhost:5432/PGC` |
| `SPRING_DATASOURCE_USERNAME` | Usuario de la base de datos | `crud_pgc` |
| `SPRING_DATASOURCE_PASSWORD` | Contraseña de la base de datos | `crud_pgc` |
| `ORS_API_KEY` | Clave API para OpenRouteService | `<your-api-key>` |

## Estructura del Proyecto

```
CRUD-PGC/
├── src/main/java/co/edu/unipiloto/CRUD_PGC/
│   ├── controller/      # Controladores REST
│   ├── service/         # Lógica de negocio
│   ├── repository/      # Repositorios JPA
│   ├── model/           # Entidades del dominio
│   ├── dto/             # Objetos de transferencia de datos
│   ├── mapper/          # Mapeadores entre entidades y DTOs
│   ├── exception/       # Manejo de excepciones
│   └── config/          # Configuración de la aplicación
├── src/main/resources/
│   └── application.properties
├── src/test/            # Pruebas unitarias
├── pom.xml              # Configuración de Maven
└── mvnw                 # Maven Wrapper
```