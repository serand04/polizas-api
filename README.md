# API Gestión de Pólizas

API REST desarrollada con Spring Boot para la gestión de pólizas de arrendamiento.

## Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger (OpenAPI)
- Maven

## Arquitectura

La aplicación sigue una arquitectura por capas:

controller → exposición de endpoints  
service → lógica de negocio  
repository → acceso a datos  
model → entidades del dominio

## Endpoints principales

### Listar pólizas

GET /api/polizas?tipo=COLECTIVA&estado=ACTIVA

### Obtener riesgos de una póliza

GET /api/polizas/{id}/riesgos

### Agregar riesgo

POST /api/polizas/{id}/riesgos

### Cancelar riesgo

POST /api/riesgos/{id}/cancelar

### Renovar póliza

POST /api/polizas/{id}/renovar

### Cancelar póliza

POST /api/polizas/{id}/cancelar

## Seguridad

Todos los endpoints requieren el header:

x-api-key: 123456

## Mock CORE

Endpoint simulado para integración:

POST /core-mock/evento

Ejemplo de payload:

{
"evento": "ACTUALIZACION",
"polizaId": 555
}

## Ejecutar proyecto

mvn spring-boot:run

## Swagger

Documentación disponible en:

http://localhost:8080/swagger-ui.html

## Base de datos

Se utiliza H2 en memoria.

Consola disponible en:

http://localhost:8080/h2-console