# Legal Service Portal API

## Descripción
Esta API backend está diseñada para gestionar los procesos de un portal de servicios legales. Proporciona una serie de endpoints RESTful para la administración de usuarios, casos legales, documentos asociados, y la gestión de diferentes tipos de clientes (personas naturales y empresas), así como abogados. La aplicación está construida con Spring Boot, lo que garantiza una arquitectura robusta, segura y escalable.

## Características Principales
-   **Gestión de Usuarios:** Registro de nuevos usuarios, creación de usuarios administradores, y modificación del estado, nombre de usuario y contraseña de los usuarios existentes. Incluye roles (Abogado, Cliente, Admin) y gestión de autenticación y autorización segura.
-   **Gestión de Casos:** Creación, consulta, actualización y eliminación de casos legales. Permite la asignación de casos a abogados y el seguimiento del estado del caso.
-   **Gestión de Documentos:** Subida, recuperación y gestión de documentos relevantes para cada caso, clasificados por tipo de documento.
-   **Gestión de Clientes:** Soporte para la administración de clientes, distinguiendo entre personas naturales y empresas, con sus respectivos detalles.
-   **Gestión de Abogados:** Administración de la información de los abogados.
-   **Seguridad:** Implementación de Spring Security para autenticación (basada en JWT) y autorización, asegurando el acceso controlado a los recursos de la API.
-   **Validación de Datos:** Validación rigurosa de entradas para mantener la integridad de los datos.

## Tecnologías Utilizadas
-   **Spring Boot:** Framework principal para el desarrollo de la aplicación.
-   **Java:** Lenguaje de programación.
-   **Maven:** Herramienta de gestión de proyectos y dependencias.
-   **Spring Security:** Para autenticación y autorización.
-   **PostgreSQL:** Base de datos relacional para el almacenamiento de información.
-   **JPA/Hibernate:** Para la persistencia de datos.
-   **Lombok:** Para reducir el boilerplate code.
-   **Swagger/OpenAPI:** Para la documentación interactiva de la API.

## Cómo Empezar
Para obtener instrucciones detalladas sobre cómo configurar, instalar y ejecutar este proyecto, por favor, consulta nuestra [Guía de Instalación](INSTALL.md).

## Estructura del Proyecto
El proyecto sigue una estructura modular, organizada por dominios y características, adheriéndose a principios de Clean Architecture para una mayor mantenibilidad y escalabilidad.

## Contribución
Las contribuciones son bienvenidas. Por favor, asegúrate de seguir los estándares de codificación y las guías de estilo del proyecto.

## Licencia
Este proyecto se distribuye bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
