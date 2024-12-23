# Microservicio de Autenticación

## Descripción general
Este proyecto demuestra cómo implementar una API REST utilizando Spring Boot 3 con autenticación basada en JWT (JSON Web Tokens). Permite registrar usuarios, iniciar sesión y verificar autenticación con roles.

## Características
- **Spring Boot 3**: Potente framework para construir aplicaciones.
- **JWT**: Manejo seguro de autenticación y autorización.
- **Validación**: Uso de DTOs y validaciones con anotaciones.
- **Registro y autenticación**: Endpoints para registrar usuarios y obtener un token JWT.

## Requisitos
- Java 17
- Maven 3.6+
- Una base de datos (MySQL)

## Endpoints

### `POST /login`
- **Descripción / Description**:
  - **ES:** Autentica a un usuario registrado mediante sus credenciales (nombre de usuario y contraseña) y devuelve un token JWT.
  - **EN:** Authenticates a registered user via their credentials (username and password) and returns a JWT token.

- **Request Body**:
  ```json
  {
    "userName": "string",
    "password": "string"
  }
  ```

- **Responses**:
  - `200 OK`: Devuelve el token JWT.
  - `400 Bad Request`: Credenciales inválidas o errores en los datos.

### `POST /register`
- **Descripción**:
  - Registra un nuevo usuario con los datos proporcionados.

- **Request Body**:
  ```json
  {
    "userName": "string",
    "password": "string",
  }
  ```

- **Responses**:
  - `201 Created`: Usuario registrado exitosamente.
  - `400 Bad Request`: Campos inválidos o el usuario ya existe.

### `GET /checkToken`
- **Descripción**:
  - Verifica si el usuario autenticado tiene acceso.
  
- **Responses**:
  - `200 OK`: Usuario autenticado.
- `401 unauthorized`: Usuario no autenticado.
---

## Instrucciones de configuración

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/fer-gc05/Authentication-Microservice.git
   ```

2. Configurar las propiedades de la aplicación en `application.properties`.

3. Construir y ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Estructura del proyecto
```
Authentication Microservice/
|-- src/
|   |-- main/
|       |-- java/com/security/microservice/
|           |-- controllers/       # Controladores REST
|           |-- dtos/             # Objetos de Transferencia de Datos
|           |-- models/           # Modelos de Entidad
|           |-- repositories/      # Repositorios de Base de Datos
|           |-- services/         # Lógica de Negocio
|           |-- security/         # Configuraciones de Seguridad y JWT
|       |-- resources/
|           |-- application.properties # Configuración
|-- pom.xml                     # Configuración de Construcción de Maven
```

## Dependencias
Principales dependencias utilizadas en este proyecto:
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Tokens)
- MySQL Driver
- Lombok
- Maven

Para ver la lista completa de dependencias, consulta el archivo `pom.xml`.

## Configuración
Principales propiedades de configuración en `application.properties`:

```properties
# Configuración de la Base de Datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-user
spring.datasource.password=your-password

# Configuración JPA/Hibernate
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# Configuración JWT
# Nota: Genera tu propia clave secreta de al menos 256 bits
jwt.secret= your-keysecret
jwt.expiration=3600    # Tiempo de expiración del token en segundos
```

## Seguridad
El microservicio implementa las siguientes medidas de seguridad:

- Contraseñas cifradas usando BCrypt
- Tokens JWT para autenticación sin estado
- Control de acceso basado en roles (ROLE_USER, ROLE_ADMIN)
- Cabeceras de seguridad HTTP

## Pruebas
Ejecuta las pruebas unitarias con Maven:

```bash
mvn test
```

Para pruebas de integración:
```bash
mvn verify
```

## Despliegue
Para desplegar en producción:

1. Actualiza la configuración en `application-prod.properties`
2. Construye el JAR:
   ```bash
   mvn clean package -P prod
   ```
3. Ejecuta con perfil de producción:
   ```bash
   java -jar target/auth-service.jar --spring.profiles.active=prod
   ```

## Contribuciones

- No dudes en abrir issues o enviar pull requests para cualquier error o solicitud de funcionalidad

## Contacto
- Link del Proyecto: [Authentication Microservice](https://github.com/fer-gc05/Authentication-Microservice.git)

