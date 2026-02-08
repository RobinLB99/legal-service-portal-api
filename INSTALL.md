# Guía de Instalación y Ejecución de Legal Service Portal API (Usando Docker Compose)

Esta guía detalla los pasos necesarios para configurar, instalar y ejecutar la API de Legal Service Portal utilizando Docker Compose. Esta es la forma recomendada para poner en marcha la aplicación, ya que gestiona todas las dependencias y servicios en contenedores aislados.

## 1. Prerrequisitos

Asegúrate de tener instalados los siguientes componentes en tu sistema:

*   **Docker y Docker Compose:** Para ejecutar la aplicación y la base de datos en contenedores.
    *   Puedes verificar sus versiones con: `docker -v` y `docker compose version`

## 2. Configuración del Entorno

### 2.1 Variables de Entorno

Crea un archivo `.env` en la raíz del proyecto (al mismo nivel que `pom.xml`) basado en el archivo `.env.example`. Este archivo contendrá la configuración para la base de datos y el puerto de la aplicación.

Ejemplo de `.env`:
```dotenv
APP_PORT=8080

POSTGRES_DB=legal_service_db
POSTGRES_USER=admin
POSTGRES_PASSWORD=your_super_secret_password
POSTGRES_PORT=5432

# SPRING_DATASOURCE_URL se configura automáticamente en docker-compose.yml para usar el servicio 'db'
# SPRING_JPA_HIBERNATE_DDL_AUTO=update
```
**Asegúrate de reemplazar `your_super_secret_password` con una contraseña segura para tu base de datos.**
Las variables `SPRING_DATASOURCE_URL` y `SPRING_JPA_HIBERNATE_DDL_AUTO` son manejadas directamente en `docker-compose.yml` para el entorno Dockerizado y no necesitan ser configuradas aquí para la ejecución con Docker Compose.

## 3. Instalación

### 3.1 Clonar el Repositorio

Si aún no lo has hecho, clona el repositorio del proyecto:
```bash
git clone <URL_DEL_REPOSITORIO>
cd legal-service-portal-api
```

## 4. Ejecución con Docker Compose

Esta es la forma recomendada para ejecutar la API y su base de datos.

1.  **Asegúrate de que Docker esté corriendo en tu sistema.**
2.  **Crea el archivo `.env`** como se describe en la sección 2.1.
3.  **Inicia los servicios de Docker Compose:**
    ```bash
    docker compose up --build -d
    ```
    *   El flag `--build` reconstruirá las imágenes si hay cambios en el código o en los Dockerfiles.
    *   El flag `-d` ejecutará los contenedores en modo 'detached' (en segundo plano).
    *   Este comando iniciará el contenedor de la base de datos PostgreSQL y el contenedor de la API.
    *   La API estará disponible en `http://localhost:8080`.
    *   La base de datos PostgreSQL estará accesible en `localhost:5432`.

4.  **Para ver los logs de la aplicación:**
    ```bash
    docker compose logs -f api
    ```

5.  **Para detener los servicios:**
    ```bash
    docker compose down
    ```

## 5. Acceso a la API

Una vez que la API esté en ejecución, podrás acceder a ella a través de `http://localhost:8080`.

*   **Documentación de la API (Swagger UI):**
    *   `http://localhost:8080/swagger-ui.html`

*   **Actuator Endpoints (para monitoreo):**
    *   `http://localhost:8080/actuator`

## 6. Ejecución de Pruebas (Dentro del Contenedor de Build)

Para ejecutar las pruebas unitarias y de integración del proyecto, puedes hacerlo utilizando el entorno de build de Docker:
```bash
docker compose run --rm api mvn test
```
*   `--rm` elimina el contenedor una vez que el comando termina.
*   `api` es el nombre del servicio donde se define el build de la aplicación.

---

¡Eso es todo! Ahora deberías tener la API de Legal Service Portal funcionando y ser capaz de interactuar con ella.