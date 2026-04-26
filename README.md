# Fuel Distribution Management System - Backend (CRUD-PGC)

## Descripción

Este proyecto es el backend para un **Sistema de Gestión de Distribución de Combustible**. Proporciona una estructura robusta y una API RESTful diseñada para administrar eficazmente la cadena de suministro de combustible.

El proyecto está construido con Java y Spring Boot y forma parte del grupo `co.edu.unipiloto` (Universidad Piloto de Colombia).

## Características Principales

*   **Operaciones CRUD completas:** Gestión de entidades reguladoras, distribuidores de combustible, estaciones de servicio, compradores, solicitudes de suministro y ventas.
*   **Lógica de Negocio y Procesamientos:**
    *   Aplicación de decretos regulatorios.
    *   Aprovisionamiento de combustible.
    *   Asignación y cálculo de precios.
    *   Registro de ventas a clientes.
    *   Gestión y aplicación de subsidios.
    *   Generación automatizada de reportes estadísticos.
*   **Pruebas e Integración:** La API está preparada para ser consumida y verificada mediante **Postman** o integrada con una **interfaz de usuario en Android**.

## Tecnologías Utilizadas

*   **Java 17**
*   **Spring Boot (4.0.6)**: Framework principal.
*   **Spring Data JPA**: Para el acceso a datos y mapeo objeto-relacional (ORM).
*   **Spring Web MVC**: Para la creación de los endpoints RESTful.
*   **H2 Database**: Base de datos relacional en memoria, ideal para desarrollo y pruebas.
*   **Lombok**: Para reducir el código boilerplate (getters, setters, constructores).
*   **Maven**: Herramienta de gestión de dependencias y construcción (incluye Maven Wrapper).

## Requisitos Previos

*   Java Development Kit (JDK) 17.
*   No es estrictamente necesario tener Maven instalado de forma global, ya que el proyecto incluye `mvnw` (Maven Wrapper).

## Instalación y Ejecución

1.  **Abrir una terminal** y navegar a la carpeta raíz del proyecto

2.  **Construir el proyecto** (descargará las dependencias necesarias):
    ```bash
    # En Linux o macOS
    ./mvnw clean install

    # En Windows
    mvnw.cmd clean install
    ```

3.  **Ejecutar la aplicación Spring Boot**:
    ```bash
    # En Linux o macOS
    ./mvnw spring-boot:run

    # En Windows
    mvnw.cmd spring-boot:run
    ```

4.  **Acceso a la base de datos (Consola H2):**
    Por defecto, puedes acceder a la consola de la base de datos H2 mientras la aplicación está en ejecución accediendo desde tu navegador a:
    `http://localhost:8080/h2-console`
    *(Nota: Verifica las credenciales y la URL JDBC en tu archivo `application.properties` o `application.yml`).*

## Documentación de la API (Endpoints)

El sistema expone las siguientes rutas principales (asumiendo el puerto por defecto `http://localhost:8080`):

### 1. Entidades Reguladoras (`/entidades`)
*   `GET /entidades` - Listar todas las entidades reguladoras.
*   `GET /entidades/{id}` - Obtener detalles de una entidad.
*   `POST /entidades` - Registrar una nueva entidad.
*   `PUT /entidades/{id}` - Actualizar los datos de una entidad.
*   `DELETE /entidades/{id}` - Eliminar una entidad.
*   `PUT /entidades/{id}/decreto` - Aplicar o actualizar un decreto regulatorio asociado.

### 2. Distribuidores de Combustible (`/distribuidores`)
*   `GET /distribuidores` - Listar todos los distribuidores.
*   `GET /distribuidores/{id}` - Obtener detalles de un distribuidor.
*   `POST /distribuidores` - Registrar un distribuidor.
*   `PUT /distribuidores/{id}` - Actualizar un distribuidor.
*   `DELETE /distribuidores/{id}` - Eliminar un distribuidor.

### 3. Estaciones de Servicio (`/estaciones`)
*   `GET /estaciones` - Listar todas las estaciones de servicio.
*   `GET /estaciones/{id}` - Obtener detalles de una estación.
*   `POST /estaciones` - Registrar una nueva estación.
*   `PUT /estaciones/{id}` - Actualizar una estación.
*   `DELETE /estaciones/{id}` - Eliminar una estación.
*   `PUT /estaciones/{id}/precio` - Asignar o actualizar el precio del combustible para la estación.

### 4. Usuarios / Compradores (`/usuarios`)
*   `GET /usuarios` - Listar todos los usuarios.
*   `GET /usuarios/{id}` - Obtener detalles de un usuario.
*   `POST /usuarios` - Registrar un nuevo usuario.
*   `PUT /usuarios/{id}` - Actualizar un usuario.
*   `DELETE /usuarios/{id}` - Eliminar un usuario.

### 5. Solicitudes de Suministro (`/solicitudes`)
*   `GET /solicitudes` - Listar las solicitudes de suministro.
*   `POST /solicitudes` - Registrar una nueva solicitud.

### 6. Abastecimientos (`/abastecimientos`)
*   `POST /abastecimientos` - Registrar un nuevo abastecimiento de combustible en una estación.

### 7. Ventas a Clientes (`/ventas`)
*   `GET /ventas` - Listar todas las ventas realizadas.
*   `GET /ventas/{id}` - Obtener detalles de una venta específica.
*   `POST /ventas` - Registrar una nueva venta de combustible.

### 8. Subsidios (`/subsidios`)
*   `GET /subsidios` - Listar los subsidios disponibles o aplicados.
*   `POST /subsidios` - Registrar o gestionar un nuevo subsidio.

### 9. Estadísticas y Reportes (`/estadisticas`)
*   `GET /estadisticas` - Obtener datos estadísticos automatizados del sistema.

## Estructura del Proyecto

*   `src/main/java/co/edu/unipiloto/CRUD_PGC`: Contiene el código fuente organizado en entidades, controladores, repositorios y servicios.
*   `src/main/resources`: Contiene archivos de configuración (como `application.properties`).
*   `pom.xml`: Archivo de configuración principal de Maven con todas las dependencias del proyecto.
