# Java Microservice

Microservicio de Java que implementa un punto de acceso para validar su estado siguiendo principios de arquitectura limpia.

## Estructura del proyecto

```
AW12450000_HealthCheck/
├── applications/
│   └── app-service/                  # Capa de aplicación: clase Main, configuración principal del microservicio
│
├── domain/
│   ├── model/                        # Modelos del dominio (entidades, value objects, etc.)
│   └── usecase/                      # Casos de uso (lógica de negocio y orquestación)
│
├── infrastructure/
│   └── entry-points/
│       └── api-rest/                # Adaptador de entrada: controladores REST (exposición de endpoints HTTP)
│
├── deployment/
│   ├── acceptanceTest/              # Pruebas de aceptación
│   ├── performanceTest/             # Pruebas de performance o carga
│   ├── azure-pipeline.yaml          # YAML del pipeline CI (build, test, calidad, publicación de artefactos)
│   ├── swagger.yaml                 # YAML con las operaciones disponibles en el microservicio
│   └── Dockerfile                   # Dockerfile para el empaquetado y despliegue del microservicio

```

## Uso

Para levantar el microservicio usando IntelliJ Idea, hacerlo ejecutando el siguiente comando:
```
gradle bootRun
```

El llamado a realizar sera una peticion GET a `http://localhost:8080/api/usecase/life-status`.

## Calidad y pruebas

Este proyecto incluye diferentes tipos de pruebas para asegurar la calidad y el correcto funcionamiento del microservicio:

- **Pruebas unitarias:** Validan el comportamiento de funciones o componentes individuales de forma aislada.
      ```
- **Pruebas de aceptación:** Verifican que el sistema cumple los requisitos funcionales desde el punto de vista del usuario.
      ```
- **Pruebas de performance:** Evalúan el rendimiento del endpoint `/api/usecase/life-status`.
      ```
- **Pruebas de smoke:** Incluidas en las pruebas de aceptación y E2E, validan que el servicio responde correctamente.

## Arquitectura (Diagrama)

```
+-------------------+         HTTP GET /api/usecase/life-status         +-----------------------------+
|                   |  ----------------------------->  |                                              |
|  Cliente/Monitor  |                                  |  Java Microservicio                          |
|  (Orquestador,    |  <-----------------------------  |  ( Arquitectura Limpia Scaffold )            |
|   Balanceador,    |         JSON: {"status": ...}    |                                              |
|   etc.)           |                                  |                                              |
|                   |                                  |  applications/app-service                    |
|                   |                                  |    → Main & configuración                    |
|                   |                                  |                                              |
|                   |                                  |  domain/                                     |
|                   |                                  |    ├── model                                 |
|                   |                                  |    └── usecase                               |
|                   |                                  |                                              |
|                   |                                  |  infrastructure/entry-points                 |
|                   |                                  |    └── api-rest                              |
|                   |                                  |                                              |
|                   |                                  |  deployment/                                 |
|                   |                                  |    ├── acceptanceTest                        |
|                   |                                  |    └── performanceTest                       |
|                   |                                  |                                              |
|                   |                                  |  Swagger: /swagger.yaml                      |
+-------------------+                                                   +-----------------------------+

```

La arquitectura del proyecto sigue el patrón de **arquitectura limpia (Clean Architecture)**, promoviendo la separación de responsabilidades y facilitando la mantenibilidad, escalabilidad y testabilidad del sistema.

**Componentes principales:**

- **API Layer (`api/`)**: Expone los endpoints HTTP (por ejemplo, `/api/usecase/life-status`). Aquí se definen los controladores que reciben las solicitudes y devuelven las respuestas.
- **Domain Layer (`domain/`)**: Contiene la lógica de negocio central. En este caso, la lógica es simple, pero este módulo permite crecer el sistema sin acoplarlo a frameworks.
- **Services Layer (`services/`)**: Implementa la lógica de aplicación, orquestando la interacción entre el dominio y la infraestructura.
- **Infrastructure Layer (`infrastructure/`)**: Gestiona la interacción con recursos externos (bases de datos, servicios externos, etc.). En este microservicio, puede estar vacío o preparado para futuras integraciones.
- **Tests (`tests/`)**: Incluye pruebas unitarias y de aceptación para asegurar la calidad y el correcto funcionamiento del microservicio.

**Flujo de la solicitud:**

1. El cliente o sistema de monitoreo realiza una petición HTTP GET al endpoint `/api/usecase/life-status`.
2. El controlador en la capa API recibe la solicitud y delega la lógica a la función correspondiente.
3. La función retorna el estado de salud del sistema en formato JSON.
4. El controlador responde al cliente con el estado y el código HTTP adecuado.

**Ventajas de esta arquitectura:**

- Permite escalar y modificar el microservicio fácilmente.
- Facilita la realización de pruebas unitarias y de integración.
- Separa la lógica de negocio de los detalles de infraestructura

## License

This project is licensed under the MIT License.

## Despliegue con Docker/Podman/WSL

Puedes ejecutar el microservicio en un contenedor usando Docker o Podman:

1. **Construir la imagen usando Docker o Podman:**
   ```sh
   docker build -t HealthCheck .
   ```

2. **Ejecuta el contenedor:**
   ```sh
   docker run -d -p 8080:8080 HealthCheck
   ```

3. **Verifica el endpoint:**
   Acceder a los endpoints:
   ```
   http://localhost:8080/api/usecase/life-status
   ```
---

### Ejemplo de nombre de rama y repositorio

````markdown
## Estandar de ramas y repositorio

- **Repositorio:** `AW12450000_HealthCheck`
- **Rama de feature:** `feature/create-operation`
- **Rama de feature:** `feature/generate-all-test`
- **Rama de release:** `main`
`````
