# ForoHub API

API REST desarrollada con **Spring Boot** para la gestión de temas dentro de un foro.
El proyecto implementa autenticación con **JWT**, seguridad con **Spring Security**, documentación con **Swagger** y persistencia en **MySQL**.

---

# Tecnologías utilizadas

* Java 25
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* MySQL
* Swagger
* Maven

---

# Características principales

* Autenticación mediante JWT
* Seguridad con Spring Security
* CRUD completo de temas del foro
* Documentación interactiva con Swagger
* Script SQL incluido para crear la base de datos
* Arquitectura REST

---

# Configuración de la base de datos

El repositorio incluye un archivo SQL con el esquema de la base de datos:

```
/src/main/resources/templates/schema.sql
```

Este archivo contiene:

* creación de tablas
* estructura del modelo de datos

Ejecuta este script en tu base de datos MySQL antes de iniciar la aplicación.

---

# Configuración de aplicación

Ejemplo de `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ForoHub
spring.datasource.username=root
spring.datasource.password=root123

spring.jpa.show-sql=true
```

---

# Autenticación

La API utiliza **JWT** para proteger los endpoints.

Primero debes autenticarte para obtener un token.

## Endpoint de login

```
POST /login
```

### Request

```json
{
  "username": "usuario",
  "password": "password"
}
```

### Response

```json
{
  "token": "jwt_token_generado"
}
```

Este token debe enviarse en el header de las peticiones:

```
Authorization: Bearer TOKEN
```

---

# Documentación de la API

La documentación interactiva se encuentra disponible mediante **Swagger**.

Una vez iniciada la aplicación, accede a:

```
http://localhost:8080/swagger-ui.html
```

Desde allí puedes:

* probar los endpoints
* enviar requests
* ver los modelos de datos
* autenticarte con JWT

---

# Ejecutar el proyecto

1. Clonar el repositorio

```
git clone https://github.com/ItsSure/Challenge-Foro-Hub.git
```

2. Entrar al proyecto

```
cd Challenge-Foro-Hub
```

3. Ejecutar la aplicación

```
mvn spring-boot:run
```

La API quedará disponible en:

```
http://localhost:8080
```

---

# Seguridad

La aplicación utiliza **Spring Security** para:

* proteger endpoints
* validar tokens JWT
* gestionar autenticación

Todos los endpoints del sistema requieren autenticación excepto:

```
POST /login
```

---

# Autor

Challenge de Alura de backend con **Spring Boot**, enfocado en la creación de APIs seguras con autenticación JWT.
