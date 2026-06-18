# Academia Programación API

REST API para gestionar estudiantes de una academia de programación.

## Tecnologías
- Java 21
- Spring Boot 4.1.0
- Spring Data JPA
- H2 (base de datos en memoria)

## Cómo ejecutar
mvn spring-boot:run

## Endpoints
GET    /students                    - Lista todos los estudiantes
GET    /students/{email}            - Busca por email
GET    /students/course/{course}    - Filtra por curso (JAVA, PYTHON, JAVASCRIPT)
GET    /students/top/{n}            - Top N estudiantes por nota
GET    /students/stats              - Estadísticas globales
POST   /students                    - Añade un estudiante
PUT    /students/{email}/grade      - Actualiza la nota
DELETE /students/{email}            - Elimina un estudiante

## Ejemplo POST /students
{
"name": "Naim",
"email": "naim@gmail.com",
"course": "JAVA",
"grade": 8.5
}