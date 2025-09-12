🏡 Backend - App Inmobiliaria Este repositorio contiene el backend de la aplicación inmobiliaria, desarrollado con Java Spring Boot, Gradle y MySQL. Provee una API REST para la gestión de propiedades, usuarios, direcciones, imágenes, tipos de propiedad y más. 

📌 Tecnologías utilizadas:

✔️ Java 17+

✔️ Spring Boot (Web, Data JPA, Validation) 

✔️ Gradle

✔️ MySQL 

✔️ Lombok

✔️SpringDoc OpenAPI / Swagger (para documentación de la API) 

🚀 Instalación y configuración

1️⃣ Clonar el repositorio
```bash
git clone https://github.com/tuusuario/backend-inmobiliaria.git
cd backend-inmobiliaria
```

2️⃣ Configurar la base de datos Crea una base de datos en MySQL:
```sql
CREATE DATABASE inmobiliaria_db;
```

Configura el archivo application.properties o application.yml con tus credenciales:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inmobiliaria_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
3️⃣ Compilar y ejecutar ./gradlew bootRun La API quedará corriendo en: 👉 http://localhost:8080
bash
📂 Estructura del proyecto
```bash
src/main/java/com/com/example/casagariitaapi
│── controllers/    # Controladores REST
│── services/       # Lógica de negocio
│── repositories/   # Repositorios JPA
│── models/         # Entidades (Propiedad, Usuario, Dirección, etc.)
│── config/         # Configuración de la app (CORS, Swagger, etc.)
```

📖 Endpoints principales 

🔹 Propiedades

➜ GET /propiedades → Listar propiedades

➜ GET /propiedades/{id} → Obtener detalle de una propiedad

➜ POST /propiedades → Crear nueva propiedad

➜ PUT /propiedades/{id} → Editar propiedad

➜ DELETE /propiedades/{id} → Eliminar propiedad

🔹 Usuarios

➜ GET /usuarios → Listar usuarios

➜ POST /usuarios → Crear usuario

➜ PUT /usuarios/{id} → Editar usuario

➜ DELETE /usuarios/{id} → Eliminar usuario

🛠️ Scripts útiles Crear build
```bash
./gradlew build
```
Limpiar build
```bash
./gradlew clean
```
