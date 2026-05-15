# Instrucciones para el Agente (CRUD-PGC)

Al trabajar en este proyecto, por favor sigue estas reglas:

1. **Estructura de la Base de Datos:** Siempre que necesites consultar la estructura de la base de datos, tablas, relaciones o tipos de datos, lee el archivo SQL principal ubicado en: `inserts/new-sql/PGC.sql`. No me preguntes por la ubicación de la base de datos, asume que siempre es este archivo.
2. **Comandos Maven:** Utiliza siempre el wrapper de Maven (`./mvnw`) en lugar del comando global de Maven (`mvn`) para compilar, empaquetar o ejecutar pruebas (por ejemplo, usa `./mvnw clean compile` en lugar de `mvn clean compile`).